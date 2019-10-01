package com.example.github.view.binding

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.example.github.domain.model.Repo
import com.example.github.view.adapter.ReposAdapter

@BindingAdapter("listData")
fun RecyclerView.setListData(repos: PagedList<Repo>?) {
    val adapter = adapter as ReposAdapter
    adapter.submitList(repos)
}
