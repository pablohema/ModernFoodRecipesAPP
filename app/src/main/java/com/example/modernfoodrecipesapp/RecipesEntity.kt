package com.example.modernfoodrecipesapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.modernfoodrecipesapp.models.FoodRecipe
import com.example.modernfoodrecipesapp.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
