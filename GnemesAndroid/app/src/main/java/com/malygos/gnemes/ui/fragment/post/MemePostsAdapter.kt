package com.malygos.gnemes.ui.fragment.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialContainerTransform
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.databinding.ListItemMemePostBinding
import com.malygos.gnemes.ui.MainActivity
import com.malygos.gnemes.ui.MemeDetailActivity
import com.malygos.gnemes.ui.fragment.detail.MemeDetailFragment

class MemePostsAdapter(
    val fragmentManager: FragmentManager,val memePosts: List<MemePost>
) : RecyclerView.Adapter<MemePostsAdapter.MemePostHolder>() {
    private lateinit var parent:ViewGroup

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemePostsAdapter.MemePostHolder {
        this.parent =parent

        return MemePostHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_meme_post,
                parent,
                false
            )
        ).apply {
            ViewCompat.setTransitionName(this.itemView,"meme_post_img")

        }
    }

    override fun getItemCount(): Int {
        return memePosts.size
    }

    override fun onBindViewHolder(holder: MemePostsAdapter.MemePostHolder, position: Int) {
        holder.binding.memePost = memePosts[position]
        holder.binding.memeImg.setOnClickListener {
//            val newInstance = MemeDetailFragment.newInstance("1", "2")
//            fragmentManager.beginTransaction()
//                .addSharedElement(holder.binding.memeImg,"meme_post_img")
//            newInstance.show(fragmentManager,"Nothing")
            MemeDetailActivity.startActivityModel(parent.context,it)
        }
    }

    inner class MemePostHolder(val binding: ListItemMemePostBinding) :
        RecyclerView.ViewHolder(binding.root)
}