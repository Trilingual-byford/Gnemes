package com.malygos.gnemes.ui.fragment.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.databinding.ListItemMemePostBinding
import com.malygos.gnemes.ui.MainActivity
import com.malygos.gnemes.ui.fragment.detail.MemeDetailFragment

class MemePostsAdapter(
    val memePosts: List<MemePost>
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
        )
    }

    override fun getItemCount(): Int {
        return memePosts.size
    }

    override fun onBindViewHolder(holder: MemePostsAdapter.MemePostHolder, position: Int) {
        holder.binding.memePost = memePosts[position]
        holder.binding.memeImg.setOnClickListener {
            val newInstance = MemeDetailFragment.newInstance("1", "2")
            val ft = (parent.context as MainActivity).supportFragmentManager
            newInstance.show(ft,"test")
        }
    }

    inner class MemePostHolder(val binding: ListItemMemePostBinding) :
        RecyclerView.ViewHolder(binding.root)
}