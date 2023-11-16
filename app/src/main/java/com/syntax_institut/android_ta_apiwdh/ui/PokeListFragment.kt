package com.syntax_institut.android_ta_apiwdh.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.android_ta_apiwdh.data.adapter.PokeAdapter
import com.syntax_institut.android_ta_apiwdh.databinding.FragmentPokeListBinding
import com.syntax_institut.android_ta_apiwdh.ui.viewmodel.PokemonViewModel

class PokeListFragment: Fragment() {
    private lateinit var binding: FragmentPokeListBinding
    private val viewModel: PokemonViewModel by activityViewModels()
    private lateinit var adapter: PokeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokeListBinding.inflate(layoutInflater)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokeList.observe(viewLifecycleOwner) {
            binding.rvPokeList.adapter = PokeAdapter(it, viewModel)
        }

    }

    private fun setupRecyclerView() {
        adapter = PokeAdapter(emptyList(), viewModel)
        binding.rvPokeList.adapter = adapter
    }

}