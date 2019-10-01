package com.example.github.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.github.databinding.ListItemRepoBinding
import com.example.github.domain.model.Repo
import com.example.github.view.listener.ReposListener

class ReposAdapter(private val listener: ReposListener) :
    PagedListAdapter<Repo, ReposAdapter.RepoViewHolder>(RepoDiffCallback()) {

    class RepoViewHolder(val binding: ListItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root)

    class RepoDiffCallback : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemRepoBinding.inflate(inflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.repo = item
        holder.binding.listener = listener
        holder.binding.executePendingBindings()
    }
}
