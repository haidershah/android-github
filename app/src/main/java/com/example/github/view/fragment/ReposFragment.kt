package com.example.github.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.github.R
import com.example.github.databinding.FragmentReposBinding
import com.example.github.domain.model.Repo
import com.example.github.view.adapter.ReposAdapter
import com.example.github.view.listener.ReposListener
import com.example.github.viewmodel.ReposViewModel
import com.example.github.viewmodel.factory.ReposViewModelFactory

class ReposFragment : Fragment(), ReposListener {
    private val viewModel: ReposViewModel by lazy {
        ViewModelProvider(this, ReposViewModelFactory(activity!!.application))
            .get(ReposViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentReposBinding>(
            inflater,
            R.layout.fragment_repos,
            container,
            false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.reposRecyclerView.setHasFixedSize(true)
        binding.reposRecyclerView.adapter = ReposAdapter(this)

        // add dividers between RecyclerView's row items
        val dividerDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.reposRecyclerView.addItemDecoration(dividerDecoration)

        return binding.root
    }

    override fun onRepoClicked(repo: Repo) {
        findNavController().navigate(
            ReposFragmentDirections.actionReposFragmentToRepoDetailFragment(repo)
        )
    }
}
