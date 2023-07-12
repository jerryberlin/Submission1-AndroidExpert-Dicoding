package com.example.core.data.source.local.room

import androidx.room.*
import com.example.core.data.source.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe WHERE isFavorite=1")
    fun getFavoriteRecipe(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe WHERE recipeId =:id")
    fun checkId(id: Int): Flow<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: List<RecipeEntity>)

    @Update
    fun updateFavoriteRecipe(recipe: RecipeEntity)
}