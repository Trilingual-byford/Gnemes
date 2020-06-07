package com.malygos.gnemes.ui

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.malygos.gnemes.R

class MemeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_meme_detail)

    }
    companion object {
        private const val posterKey = "posterKey"
        fun startActivityModel(context: Context?, startView: View) {
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