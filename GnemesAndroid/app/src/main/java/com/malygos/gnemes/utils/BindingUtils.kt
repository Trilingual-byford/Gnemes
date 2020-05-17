package com.malygos.gnemes.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageURL")
fun ImageView.imageURI(uri: String) {
    Glide.with(this)
        .load(uri)
        .into(this)
}