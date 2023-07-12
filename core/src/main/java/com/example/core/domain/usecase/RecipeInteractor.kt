package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.Recipe
import com.example.core.domain.repository.IRecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeInteractor @Inject constructor(private val recipeRepository: IRecipeRepository) :
    RecipeUseCase {
    override fun getRecipes() = recipeRepository.getRecipes()

    override fun getDetailRecipe(id: Int): Flow<Resource<Recipe>> =
        recipeRepository.getDetailRecipe(id)

    override fun checkId(id: Int): Flow<Recipe> = recipeRepository.checkId(id)

    override fun getFavoriteRecipe() = recipeRepository.getFavoriteRecipe()

    override fun setFavoriteRecipe(recipe: Recipe, state: Boolean) =
        recipeRepository.setFavoriteRecipe(recipe, state)
}