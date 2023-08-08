package com.example.cocktailbar.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailbar.data.Repository
import com.example.cocktailbar.data.dataBase.CocktailInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditCocktailScreenViewModel@Inject constructor(
    private val repository: Repository
): ViewModel() {
    val testCocktail = CocktailInfo(
        cocktailName = "name",
        description = "description",
        ingredient = "ingredient",
        recipe = "recipe"
    )
    fun addCocktail(cocktail: CocktailInfo) {
        viewModelScope.launch {
            repository.addCocktail(cocktail)
        }
    }

    fun updateCocktail(cocktail: CocktailInfo){
        viewModelScope.launch {
            repository.updateCocktail(cocktail)
        }
    }

    fun getCocktailById(id: Int){
        viewModelScope.launch {
            val testCocktail = repository.getCocktailById(id)
        }

    }


}
