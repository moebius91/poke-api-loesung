package com.syntax_institut.android_ta_apiwdh.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.syntax_institut.android_ta_apiwdh.databinding.FragmentPokeDetailBinding
import com.syntax_institut.android_ta_apiwdh.ui.viewmodel.PokemonViewModel
import java.util.Locale

class PokeDetailFragment: Fragment() {
    private lateinit var binding: FragmentPokeDetailBinding
    private val viewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemon.observe(viewLifecycleOwner) {
            binding.tvPokeDetailName.text = it.name.capitalize(Locale.ROOT)
            binding.tvPokeDetailNumber.text = viewModel.pokeId.value.toString()

            binding.ivPokeDetailSprite.load(viewModel.pokemon.value?.sprites?.other?.officialArtwork?.frontDefault)
        }
    }
}