package com.malygos.gnemes.ui

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import kotlinx.android.synthetic.main.fragment_meme_detail.*

class MemeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_meme_detail)
        tool_bar_detail.setNavigationOnClickListener {
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