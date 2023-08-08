package com.example.cocktailbar.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailbar.data.Repository
import com.example.cocktailbar.data.dataBase.CocktailInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailListScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _allCocktails = MutableStateFlow<List<CocktailInfo>?>(null)
    val allCocktails = _allCocktails.asStateFlow()

    fun getAllCocktails() {
        viewModelScope.launch {
            val cocktails = repository.getAllCocktails()
            _allCocktails.value = cocktails
        }
    }

    fun deleteAll(){
        viewModelScope.launch {
            repository.deleteAllCocktails()
            getAllCocktails()
        }
    }


}