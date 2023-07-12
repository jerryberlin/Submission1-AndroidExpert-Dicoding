package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @field:SerializedName("glutenFree")
    val glutenFree: Boolean,

    @field:SerializedName("healthScore")
    val healthScore: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("aggregateLikes")
    val aggregateLikes: Int,

    @field:SerializedName("readyInMinutes")
    val readyInMinutes: Int,

    @field:SerializedName("dairyFree")
    val dairyFree: Boolean,

    @field:SerializedName("vegetarian")
    val vegetarian: Boolean,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("summary")
    val summary: String,

    @field:SerializedName("image")
    val image: String,

    @field:SerializedName("veryHealthy")
    val veryHealthy: Boolean,

    @field:SerializedName("vegan")
    val vegan: Boolean,

    @field:SerializedName("cheap")
    val cheap: Boolean,
)
