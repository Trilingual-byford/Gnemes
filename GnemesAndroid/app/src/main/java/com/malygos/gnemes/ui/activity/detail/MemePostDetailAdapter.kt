package com.malygos.gnemes.ui.activity.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.malygos.gnemes.R
import com.malygos.gnemes.databinding.ListItemMemeDetailBinding


class MemePostDetailAdapter(
    val fragmentManager: FragmentManager,
    val olsentences: List<String>?,
    var slsentences: List<String>?
) : RecyclerView.Adapter<MemePostDetailAdapter.MemePostDetailHolder>() {
    private lateinit var parent:ViewGroup
    val expandedList= olsentences!!.map { return@map false }.toMutableList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemePostDetailAdapter.MemePostDetailHolder {
        this.parent =parent
        val memePostDetailHolder = MemePostDetailHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_meme_detail,
                parent,
                false
            )
        )
        memePostDetailHolder.binding.hideShowBtn.setOnClickListener {
            val bindingAdapterPosition = memePostDetailHolder.bindingAdapterPosition
            expandedList[bindingAdapterPosition]=!expandedList[bindingAdapterPosition]
            notifyItemChanged(bindingAdapterPosition)
        }
        return memePostDetailHolder
    }

    override fun getItemCount(): Int {
        return olsentences.orEmpty().size
    }

    override fun onBindViewHolder(holder: MemePostDetailAdapter.MemePostDetailHolder, position: Int) {
        holder.binding.textOrigin.text= olsentences?.get(position) ?: "----"
        holder.binding.textSl.text= slsentences?.get(position) ?: "----"
//        holder.binding.hideShowBtn.setOnClickListener {
//
//        }
        val isExpanded: Boolean = expandedList[position]

        holder.binding.expandableLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE

    }

    inner class MemePostDetailHolder(val binding: ListItemMemeDetailBinding) :
        RecyclerView.ViewHolder(binding.root)
}