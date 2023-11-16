package com.syntax_institut.android_ta_apiwdh.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.android_ta_apiwdh.R
import com.syntax_institut.android_ta_apiwdh.data.model.Pokemon
import com.syntax_institut.android_ta_apiwdh.databinding.ItemPokeListBinding
import com.syntax_institut.android_ta_apiwdh.ui.viewmodel.PokemonViewModel

class PokeAdapter(
    private val dataset: List<Pokemon>,
    private val viewModel: PokemonViewModel
): RecyclerView.Adapter<PokeAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(val binding: ItemPokeListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = dataset[position]

        val url = item.url
        val pokeId = url
            .replace("https://pokeapi.co/api/v2/pokemon/","")
            .replace("/","")
            .toInt()

        val name = "$pokeId. ${item.name.capitalize()}"

        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokeId.png"

        holder.binding.ivPokeDetailImage.load(imageUrl)
        holder.binding.tvPokeListName.text = name

        holder.binding.cvPokeListPokemon.setOnClickListener {
            viewModel.savePokeId(pokeId)
            viewModel.loadPokemon(pokeId)
            holder.itemView.findNavController().navigate(R.id.pokeDetailFragment)
        }
    }

}