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
class DetailedScreenViewModel@Inject constructor(
    private val repository: Repository
): ViewModel() {
    private val _cocktail = MutableStateFlow<CocktailInfo?>(null)
    val cocktail = _cocktail.asStateFlow()

    fun getCocktailById(id:Int){
        viewModelScope.launch {
            val cocktail = repository.getCocktailById(id)
            _cocktail.value = cocktail
        }
    }

}