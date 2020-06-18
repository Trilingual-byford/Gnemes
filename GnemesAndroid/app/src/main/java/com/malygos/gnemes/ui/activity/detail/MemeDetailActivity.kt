package com.malygos.gnemes.ui.activity.detail

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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
        val memePost = viewModel.getMemePostById(postId)
        activityMemeDetailBinding.memePost= memePost
        memePost.dir?.let { bindDetailLoadImage(activityMemeDetailBinding.imgMemeDetail, it) }
        activityMemeDetailBinding.toolBarDetail.setNavigationOnClickListener {
            onBackPressed()
        }
    }
    private fun bindDetailLoadImage(view: ImageView, url: String) {
        supportPostponeEnterTransition()
        Glide.with(view.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontTransform()
            .listener(object :RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    supportStartPostponedEnterTransition();
                    return false;
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    supportStartPostponedEnterTransition();
                    return false;
                }
            })
            .into(view)
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