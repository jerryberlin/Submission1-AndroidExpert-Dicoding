package com.example.favorit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.RecipeUseCase

class FavoriteViewModel(private val recipeUseCase: RecipeUseCase) :
    ViewModel() {
    fun getFavoriteRecipe() = recipeUseCase.getFavoriteRecipe().asLiveData()
}