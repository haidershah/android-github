package com.example.github.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.databinding.ListItemRepoBinding
import com.example.github.network.model.NetworkRepo

class ReposAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<NetworkRepo, ReposAdapter.RepoViewHolder>(RepoDiffCallback()) {

    class RepoViewHolder(val binding: ListItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root)

    class RepoDiffCallback : DiffUtil.ItemCallback<NetworkRepo>() {
        override fun areItemsTheSame(oldItem: NetworkRepo, newItem: NetworkRepo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NetworkRepo, newItem: NetworkRepo): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (repo: NetworkRepo) -> Unit) {
        fun onClick(repo: NetworkRepo) = clickListener(repo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemRepoBinding.inflate(inflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.repo = item

        holder.binding.root.setOnClickListener {
            onClickListener.onClick(item)
        }

        holder.binding.executePendingBindings()
    }
}
