package com.malygos.gnemes.data.entity

import android.os.Parcelable
import androidx.room.*
import com.malygos.gnemes.data.persistence.MemeDataConverter
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(tableName = "memes")
@TypeConverters(MemeDataConverter::class)
data class MemePost(
    @PrimaryKey
    var id: Long,
    var postId: String?,
    var difficulty: Byte,
    var createdTime: String?,
    var dir: String?,
    var likes: Int?,
    var phrase: List<String>?,
    var olsentences: List<String>?,
    var slsentences: List<String>?,
    var tag: List<String>?,
    var viewer: Int?
) : Parcelable{
    constructor() : this(1,null,1, null, null, null, null, null, null,null,null)
}