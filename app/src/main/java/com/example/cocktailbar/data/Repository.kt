package com.example.cocktailbar.data

import com.example.cocktailbar.data.dataBase.CocktailInfo
import com.example.cocktailbar.data.dataBase.Dao
import javax.inject.Inject

class Repository@Inject constructor(private val dao: Dao) {

    suspend fun addCocktail(cocktail: CocktailInfo){
        dao.insertCocktail(cocktail)
    }


    suspend fun updateCocktail(cocktail: CocktailInfo){
        dao.updateCocktail(cocktail)
    }

    suspend fun getCocktailById(id: Int): CocktailInfo {
        return dao.getCocktailById(id)
    }

    suspend fun getAllCocktails(): List<CocktailInfo> {
        return dao.getAllCocktails()
    }

    suspend fun deleteAllCocktails() {
        dao.deleteAllCocktails()
        dao.resetPrimaryKey()
    }
}