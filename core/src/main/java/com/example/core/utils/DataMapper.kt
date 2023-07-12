package com.example.core.utils

import com.example.core.data.source.local.entity.RecipeEntity
import com.example.core.data.source.remote.response.RecipeResponse
import com.example.core.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {
    fun mapResponsesToEntities(input: List<RecipeResponse>): List<RecipeEntity> {
        val recipeList = ArrayList<RecipeEntity>()
        input.map {
            val recipe = RecipeEntity(
                glutenFree = it.glutenFree,
                healthScore = it.healthScore,
                title = it.title,
                aggregateLikes = it.aggregateLikes,
                readyInMinutes = it.readyInMinutes,
                dairyFree = it.dairyFree,
                vegetarian = it.vegetarian,
                recipeId = it.id,
                summary = it.summary,
                image = it.image,
                veryHealthy = it.veryHealthy,
                vegan = it.vegan,
                cheap = it.cheap,
                isFavorite = false
            )
            recipeList.add(recipe)
        }
        return recipeList
    }

    fun mapResponseToDomain(input: RecipeResponse): Flow<Recipe> {
        return flowOf(
            Recipe(
                input.glutenFree,
                input.healthScore,
                input.title,
                input.aggregateLikes,
                input.readyInMinutes,
                input.dairyFree,
                input.vegetarian,
                input.id,
                input.summary,
                input.image,
                input.veryHealthy,
                input.vegan,
                input.cheap,
                false
            )
        )
    }

    fun mapEntitiesToDomain(input: List<RecipeEntity>): List<Recipe> =
        input.map {
            Recipe(
                glutenFree = it.glutenFree,
                healthScore = it.healthScore,
                title = it.title,
                aggregateLikes = it.aggregateLikes,
                readyInMinutes = it.readyInMinutes,
                dairyFree = it.dairyFree,
                vegetarian = it.vegetarian,
                recipeId = it.recipeId,
                summary = it.summary,
                image = it.image,
                veryHealthy = it.veryHealthy,
                vegan = it.vegan,
                cheap = it.cheap,
                isFavorite = it.isFavorite
            )
        }

    fun mapEntityToDomain(input: RecipeEntity): Recipe =
        Recipe(
            glutenFree = input.glutenFree,
            healthScore = input.healthScore,
            title = input.title,
            aggregateLikes = input.aggregateLikes,
            readyInMinutes = input.readyInMinutes,
            dairyFree = input.dairyFree,
            vegetarian = input.vegetarian,
            recipeId = input.recipeId,
            summary = input.summary,
            image = input.image,
            veryHealthy = input.veryHealthy,
            vegan = input.vegan,
            cheap = input.cheap,
            isFavorite = input.isFavorite
        )


    fun mapDomainToEntity(input: Recipe) = RecipeEntity(
        glutenFree = input.glutenFree,
        healthScore = input.healthScore,
        title = input.title,
        aggregateLikes = input.aggregateLikes,
        readyInMinutes = input.readyInMinutes,
        dairyFree = input.dairyFree,
        vegetarian = input.vegetarian,
        recipeId = input.recipeId,
        summary = input.summary,
        image = input.image,
        veryHealthy = input.veryHealthy,
        vegan = input.vegan,
        cheap = input.cheap,
        isFavorite = input.isFavorite
    )
}