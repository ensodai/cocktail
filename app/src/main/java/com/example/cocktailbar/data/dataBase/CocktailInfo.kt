package com.example.cocktailbar.data.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktail_item")
data class CocktailInfo(
    @ColumnInfo(name = "cocktail_name")
    val cocktailName: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "ingredient")
    val ingredient: String,
    @ColumnInfo(name = "recipe")
    val recipe: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
