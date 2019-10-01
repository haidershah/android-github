package com.example.github.view.callback

import androidx.paging.PagedList
import com.example.github.domain.model.Repo

class RepoBoundaryCallback(
    private val onGetRepos: () -> Unit
) : PagedList.BoundaryCallback<Repo>() {

    /**
     * Database returned 0 items. No need to fetch repos when database returns no items as we
     * always fetch repos when we enter the app so that we can get fresh data.
     */
    override fun onZeroItemsLoaded() {
    }

    /**
     * When all items in the database were loaded, we need to query the backend for more items.
     */
    override fun onItemAtEndLoaded(itemAtEnd: Repo) {
        onGetRepos()
    }
}
