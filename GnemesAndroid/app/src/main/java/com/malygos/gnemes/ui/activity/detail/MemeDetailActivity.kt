package com.malygos.gnemes.ui.activity.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
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
import com.malygos.gnemes.ui.fragment.post.NewPostViewModelFactory
import com.skydoves.transformationlayout.TransformationAppCompatActivity
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import kotlinx.android.synthetic.main.activity_meme_detail.*


class MemeDetailActivity : TransformationAppCompatActivity() {

    lateinit var memePost: MemePost
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMemeDetailBinding: ActivityMemeDetailBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_meme_detail
        )
        val postId = intent.getStringExtra("postId")
        val repository = MemePostRepository(
            GnemesApiService.gnemesApiService,
            MemeDataBase.getMemeDataBase()
        )
        val viewModel = ViewModelProviders.of(this, NewPostViewModelFactory(repository))
            .get(MemeDetailViewModel::class.java)
        val memePost = viewModel.getMemePostById(postId)
        activityMemeDetailBinding.memePost = memePost
        memePost.Dir?.let {
            Glide.with(this)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontTransform()
                .into(activityMemeDetailBinding.imgMemeDetail)
        }
        recycler_memePostDetail.layoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        recycler_memePostDetail.adapter = MemePostDetailAdapter(
            this.supportFragmentManager,
            memePost.OLSentences,
            memePost.SLSentences
        )

        activityMemeDetailBinding.toolBarDetail.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun bindDetailLoadImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontTransform()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false;
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false;
                }
            })
            .into(view)
    }

    companion object {
        fun startMemeDetailActivity(
            context: Context?,
            transformationLayout: TransformationLayout,
            postId: String
        ) {
            if (context is Activity) {
                val intent = Intent(context, MemeDetailActivity::class.java)
                intent.putExtra("postId", postId)
                TransformationCompat.startActivity(transformationLayout, intent)
            }
        }
    }
}