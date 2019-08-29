package com.example.github.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.github.R
import com.example.github.databinding.FragmentReposBinding

class ReposFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentReposBinding>(
            inflater,
            R.layout.fragment_repos,
            container,
            false
        )

        return binding.root
    }
}
