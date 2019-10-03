package com.example.github.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.github.R
import com.example.github.databinding.FragmentRepoDetailBinding
import com.example.github.viewmodel.RepoDetailViewModel
import com.example.github.viewmodel.factory.RepoDetailViewModelFactory

class RepoDetailFragment : Fragment() {

    private val viewModel: RepoDetailViewModel by lazy {
        val repo = RepoDetailFragmentArgs.fromBundle(arguments!!).repo
        ViewModelProvider(this, RepoDetailViewModelFactory(repo))
            .get(RepoDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRepoDetailBinding>(
            inflater, R.layout.fragment_repo_detail, container, false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }
}
