package com.example.github.view.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.github.model.Repo

@BindingAdapter("listData")
fun TextView.setListData(repos: List<Repo>?) {
    text = repos.toString()
}
