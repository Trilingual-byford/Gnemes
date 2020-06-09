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
    var olsentences: List<String>?,
    var phrase: List<String>?,
    var slsentences: List<String>?,
    var tag: List<String>?,
    var viewer: Int?
) : Parcelable