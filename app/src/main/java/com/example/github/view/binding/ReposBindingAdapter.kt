package com.example.github.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.network.model.NetworkRepo
import com.example.github.view.adapter.ReposAdapter

@BindingAdapter("listData")
fun RecyclerView.setListData(repos: List<NetworkRepo>?) {
    val adapter = adapter as ReposAdapter
    adapter.submitList(repos)
}
