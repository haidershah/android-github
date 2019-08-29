package com.example.github.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.github.R
import com.example.github.databinding.FragmentReposBinding
import com.example.github.viewmodel.ReposViewModel

class ReposFragment : Fragment() {

    private val viewModel: ReposViewModel by lazy {
        ViewModelProviders.of(this).get(ReposViewModel::class.java)
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

        return binding.root
    }
}
