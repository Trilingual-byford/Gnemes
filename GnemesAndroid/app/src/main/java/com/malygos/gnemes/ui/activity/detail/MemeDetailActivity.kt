package com.malygos.gnemes.ui.activity.detail

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.data.network.GnemesApiService
import com.malygos.gnemes.data.persistence.MemeDataBase
import com.malygos.gnemes.data.repository.MemePostRepository
import com.malygos.gnemes.databinding.ActivityMemeDetailBinding
import com.malygos.gnemes.ui.fragment.post.NewPostViewModel
import com.malygos.gnemes.ui.fragment.post.NewPostViewModelFactory

class MemeDetailActivity : AppCompatActivity() {

    lateinit var memePost: MemePost
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMemeDetailBinding: ActivityMemeDetailBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_meme_detail)
        val postId = intent.getLongExtra("postId", 0)
        val repository = MemePostRepository(
            GnemesApiService.gnemesApiService,
            MemeDataBase.getMemeDataBase()
        )
        val viewModel = ViewModelProviders.of(this, NewPostViewModelFactory(repository))
            .get(MemeDetailViewModel::class.java)
        activityMemeDetailBinding.memePost=viewModel.getMemePostById(postId)
        activityMemeDetailBinding.toolBarDetail.setNavigationOnClickListener {
            onBackPressed()
        }
    }
    companion object {
        fun startActivityModel(
            context: Context?,
            startView: View,
            postId: Long
        ) {
            if (context is Activity) {
                val intent = Intent(context, MemeDetailActivity::class.java)
                val options = ActivityOptions.makeSceneTransitionAnimation(context,
                    startView, "meme_post_img"
                )
                intent.putExtra("postId",postId)
                context.startActivity(intent, options.toBundle())
            }
        }
    }
}