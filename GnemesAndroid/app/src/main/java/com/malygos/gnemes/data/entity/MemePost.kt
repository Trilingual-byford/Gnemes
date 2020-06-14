package com.malygos.gnemes.data.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(tableName = "memes")
data class MemePost(
    @Embedded
    var comment: List<MemeComment>?,
    var createdTime: String?,
    var dir: String?,
    @PrimaryKey
    var id: Int,
    var likes: Int?,
    @Embedded
    var olsentences: List<String>?,
    @Embedded
    var phrase: List<String>?,
    @Embedded
    var slsentences: List<String>?,
    @Embedded
    var tag: List<String>?,
    var viewer: Int?
) : Parcelable{
    constructor() : this(null, null, null, 1, null, null, null, null,null,null)
}