package com.malygos.gnemes.ui.fragment.post

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malygos.gnemes.databinding.ListItemMemePostBinding

class MemePostsAdapter: RecyclerView.Adapter<MemePostsAdapter.MemePostHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemePostsAdapter.MemePostHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MemePostsAdapter.MemePostHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MemePostHolder(val binding:ListItemMemePostBinding): RecyclerView.ViewHolder(binding.root)
//    inner class QuoteViewHolder(val binding: ItemQuoteBinding) :
//        RecyclerView.ViewHolder(binding.root)
}