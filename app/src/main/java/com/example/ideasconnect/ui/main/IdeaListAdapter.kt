package com.example.ideasconnect.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ideasconnect.data.response.IdeaListItem
import com.example.ideasconnect.databinding.ItemLayoutBinding
import com.example.ideasconnect.ui.detail.DetailActivity

class IdeaListAdapter : RecyclerView.Adapter<IdeaListAdapter.IdeaListViewHolder>() {

    private var ideaList = ArrayList<IdeaListItem>()

    fun addIdeaList(list: List<IdeaListItem>) {
        this.ideaList.clear()
        this.ideaList.addAll(list)
        notifyDataSetChanged()
    }

    inner class IdeaListViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val itemNow = ideaList[position]

            binding.tvIdeaTitle.text = itemNow.ideaTitle
            binding.tvIdeaDescription.text = itemNow.ideaDescription
            binding.tvDate.text = itemNow.submissionDate
            binding.tvDeveloperName.text = itemNow.developerName

            binding.itemLayout.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_IDEA_DETAIL, itemNow)
                itemView.context.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdeaListViewHolder {
        return IdeaListViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return ideaList.size
    }

    override fun onBindViewHolder(holder: IdeaListViewHolder, position: Int) {
        holder.bind(position)
    }
}