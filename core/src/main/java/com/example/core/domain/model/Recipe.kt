package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val glutenFree: Boolean,
    val healthScore: Int,
    val title: String,
    val aggregateLikes: Int,
    val readyInMinutes: Int,
    val dairyFree: Boolean,
    val vegetarian: Boolean,
    val recipeId: Int,
    val summary: String,
    val image: String,
    val veryHealthy: Boolean,
    val vegan: Boolean,
    val cheap: Boolean,
    val isFavorite: Boolean
) : Parcelable