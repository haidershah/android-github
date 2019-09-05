package com.example.github.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.github.R
import com.example.github.databinding.FragmentReposBinding
import com.example.github.view.adapter.ReposAdapter
import com.example.github.viewmodel.ReposViewModel
import com.example.github.viewmodel.factory.ReposViewModelFactory

class ReposFragment : Fragment() {

    private val viewModel: ReposViewModel by lazy {
        ViewModelProviders.of(this, ReposViewModelFactory(context!!))
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

        val adapter = ReposAdapter(ReposAdapter.OnClickListener {
            findNavController().navigate(
                ReposFragmentDirections.actionReposFragmentToRepoDetailFragment(it)
            )
        })
        binding.reposRecyclerView.adapter = adapter

        return binding.root
    }
}
