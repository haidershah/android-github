package com.example.github.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.network.model.Repo
import com.example.github.view.adapter.ReposAdapter

@BindingAdapter("listData")
fun RecyclerView.setListData(repos: List<Repo>?) {
    val adapter = adapter as ReposAdapter
    adapter.submitList(repos)
}
