package com.malygos.gnemes.data.entity

import android.os.Parcelable
import androidx.room.*
import com.malygos.gnemes.data.persistence.MemeDataConverter
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

//{
//    "CreatedTime": "2020-07-21T16:49:50.306Z",
//    "Difficulty": 100,
//    "OwnerId": "",
//    "Dir": "https://genemes-pic.s3.ap-northeast-1.amazonaws.com/funny-wholesome-animal-memes-7.jpg",
//    "Likes": 0,
//    "Viewer": 0,
//    "Tag": [
//    "cat",
//    "cats",
//    "vacation",
//    "floor"
//    ],
//    "PicHash": "Hash: 010110011100011111001001111110100011 [algoId: -1429398277]",
//    "OLSentences": [
//    "only pack essentials when going on vacation"
//    ],
//    "SLSentences": [
//    "休暇に行くときに必要なものだけを詰める"
//    ],
//    "Phrase": [
//    "essentials",
//    "vacation"
//    ]
//},
@Parcelize
@Entity(tableName = "memes")
@TypeConverters(MemeDataConverter::class)
data class MemePost(
    @PrimaryKey
    var id: String,
    var postId: String?,
    var Difficulty: Byte,
    var CreatedTime: String?,
    var Dir: String?,
    var Likes: Int?,
    var Phrase: List<String>?,
    var OLSentences: List<String>?,
    var SLSentences: List<String>?,
    var Tag: List<String>?,
    var Viewer: Int?
) : Parcelable{
    constructor() : this("",null,1, null, null, null, null, null, null,null,null)
}