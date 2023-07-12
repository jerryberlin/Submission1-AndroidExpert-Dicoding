package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeUseCase {
    fun getRecipes(): Flow<Resource<List<Recipe>>>
    fun getDetailRecipe(id: Int): Flow<Resource<Recipe>>
    fun checkId(id: Int): Flow<Recipe>
    fun getFavoriteRecipe(): Flow<List<Recipe>>
    fun setFavoriteRecipe(recipe: Recipe, state: Boolean)
}