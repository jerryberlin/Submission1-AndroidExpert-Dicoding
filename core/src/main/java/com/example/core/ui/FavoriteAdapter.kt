package com.example.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databinding.ItemListRecipeBinding
import com.example.core.domain.model.Recipe
import com.example.core.utils.htmlParser

class FavoriteAdapter(
    private var listRecipe: List<Recipe>
) : RecyclerView.Adapter<FavoriteAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: FavoriteAdapter.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: FavoriteAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemListRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemListRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val recipe = listRecipe[position]
        Glide.with(holder.itemView.context)
            .load(recipe.image)
            .into(holder.binding.imgRecipe)
        holder.apply {
            binding.tvTitle.text = recipe.title
            binding.tvSummary.text = htmlParser(recipe.summary)
            binding.tvReadyInMinutes.text = recipe.readyInMinutes.toString()
            binding.ivHealthy.setImageResource(
                when (recipe.veryHealthy.toString()) {
                    "true" -> R.drawable.ic_healthy
                    else -> R.drawable.ic_unhealthy
                }
            )
            binding.ivVegetarian.setImageResource(
                when (recipe.vegetarian.toString()) {
                    "true" -> R.drawable.ic_vege
                    else -> R.drawable.ic_nonvege
                }
            )
            binding.ivCheap.setImageResource(
                when (recipe.cheap.toString()) {
                    "true" -> R.drawable.ic_cheap
                    else -> R.drawable.ic_expensive
                }
            )
            binding.cardView.setOnClickListener {
                onItemClickCallback.onItemClicked(listRecipe[holder.adapterPosition])
            }
        }

    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Recipe)
    }
}