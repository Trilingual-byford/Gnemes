package com.malygos.gnemes.data.entity

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.*
@Parcelize
data class MemeComment(
    var id: Long,
    var userName: String? =null,
    var comment: String?,
    var postDate: Date
) : Parcelable