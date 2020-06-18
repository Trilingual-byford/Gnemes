package com.malygos.gnemes.utils

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey

//@BindingAdapter("imageURL")
//fun ImageView.imageURI(uri: String) {
//    Glide.with(this)
//        .load(uri)
//        .diskCacheStrategy(DiskCacheStrategy.ALL)
//        .into(this)
//}
//
//@BindingAdapter("imageURL")
//fun imageURL(view: ImageView, url: String) {
//    Glide.with(view.context)
//        .load(url)
//        .into(view)
//}
@BindingAdapter("loadImage")
fun bindLoadImage(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(view).apply {
            RequestOptions().dontTransform() // this line
        }
}
