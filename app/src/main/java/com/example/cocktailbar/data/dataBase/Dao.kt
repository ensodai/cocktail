package com.example.cocktailbar.data.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Insert
    suspend fun insertCocktail(cocktail: CocktailInfo)

    @Update
    suspend fun updateCocktail(cocktail: CocktailInfo)

    @Query("SELECT * FROM cocktail_item")
    suspend fun getAllCocktails(): List<CocktailInfo>

    @Query("SELECT * FROM cocktail_item WHERE id = :id")
    suspend fun getCocktailById(id: Int): CocktailInfo

    @Query("DELETE FROM cocktail_item")
    suspend fun deleteAllCocktails()

    @Query("DELETE FROM sqlite_sequence WHERE name = 'cocktail_item'")
    suspend fun resetPrimaryKey()

}