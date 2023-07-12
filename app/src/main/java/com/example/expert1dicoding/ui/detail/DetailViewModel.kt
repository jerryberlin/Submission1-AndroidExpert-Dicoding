package com.example.expert1dicoding.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.model.Recipe
import com.example.core.domain.usecase.RecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val recipeUseCase: RecipeUseCase) : ViewModel() {
    fun getDetailRecipe(id: Int) = recipeUseCase.getDetailRecipe(id).asLiveData()

    fun checkId(id: Int) = recipeUseCase.checkId(id).asLiveData()

    fun setFavoriteRecipe(recipe: Recipe, state: Boolean) =
        recipeUseCase.setFavoriteRecipe(recipe, state)

}