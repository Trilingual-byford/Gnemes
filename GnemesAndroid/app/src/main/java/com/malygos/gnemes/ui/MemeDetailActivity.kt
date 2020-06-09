package com.malygos.gnemes.ui

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.databinding.ActivityMemeDetailBinding
import kotlinx.android.synthetic.main.activity_meme_detail.*

class MemeDetailActivity : AppCompatActivity() {

    lateinit var memePost: MemePost
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMemeDetailBinding: ActivityMemeDetailBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_meme_detail)
//        activityMemeDetailBinding.memePost=
            activityMemeDetailBinding.toolBarDetail.setNavigationOnClickListener {
            onBackPressed()
        }
    }
    companion object {
        fun startActivityModel(
            context: Context?,
            startView: View,
            memePost: MemePost
        ) {
            if (context is Activity) {
                val intent = Intent(context, MemeDetailActivity::class.java)
                val options = ActivityOptions.makeSceneTransitionAnimation(context,
                    startView, "meme_post_img"
                )
                context.startActivity(intent, options.toBundle())
            }
        }
    }
}