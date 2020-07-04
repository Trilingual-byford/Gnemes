package com.malygos.gnemes.ui.activity.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.databinding.ListItemMemeDetailBinding
import com.malygos.gnemes.databinding.ListItemMemePostBinding
import com.malygos.gnemes.ui.activity.MainActivity
import com.malygos.gnemes.ui.activity.detail.MemeDetailActivity

class MemePostDetailAdapter(
    val fragmentManager: FragmentManager,
    val olsentences: List<String>?,
    var slsentences: List<String>?
) : RecyclerView.Adapter<MemePostDetailAdapter.MemePostDetailHolder>() {
    private lateinit var parent:ViewGroup

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemePostDetailAdapter.MemePostDetailHolder {
        this.parent =parent
        return MemePostDetailHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_meme_detail,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return olsentences.orEmpty().size
    }

    override fun onBindViewHolder(holder: MemePostDetailAdapter.MemePostDetailHolder, position: Int) {
        holder.binding.textOrigin.text= olsentences?.get(position) ?: "----"
        holder.binding.textSl.text= slsentences?.get(position) ?: "----"
        holder.binding.hideShowBtn.setOnClickListener {
            if(holder.binding.textSl.visibility==View.GONE){
                holder.binding.textSl.visibility= View.VISIBLE
            }else{
                holder.binding.textSl.visibility= View.GONE
            }
        }
    }

    inner class MemePostDetailHolder(val binding: ListItemMemeDetailBinding) :
        RecyclerView.ViewHolder(binding.root)
}