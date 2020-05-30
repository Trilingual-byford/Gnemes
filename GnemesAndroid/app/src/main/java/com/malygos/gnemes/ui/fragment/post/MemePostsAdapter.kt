package com.malygos.gnemes.ui.fragment.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.databinding.ListItemMemePostBinding

class MemePostsAdapter(
    val memePosts: List<MemePost>
) : RecyclerView.Adapter<MemePostsAdapter.MemePostHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemePostsAdapter.MemePostHolder {
        return MemePostHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_meme_post,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return memePosts.size
    }

    override fun onBindViewHolder(holder: MemePostsAdapter.MemePostHolder, position: Int) {
        holder.binding.memePost = memePosts[position]
    }

    inner class MemePostHolder(val binding: ListItemMemePostBinding) :
        RecyclerView.ViewHolder(binding.root)
}