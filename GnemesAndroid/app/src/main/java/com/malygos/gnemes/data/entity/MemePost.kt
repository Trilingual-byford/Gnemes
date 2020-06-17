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
    var comment: List<MemeComment>?,
    var createdTime: String?,
    var dir: String?,
    @PrimaryKey
    var id: Long,
    var likes: Int?,
    var olsentences: List<String>?,
    var phrase: List<String>?,
    var slsentences: List<String>?,
    var tag: List<String>?,
    var viewer: Int?
) : Parcelable{
    constructor() : this(null, null, null, 1, null, null, null, null,null,null)
}