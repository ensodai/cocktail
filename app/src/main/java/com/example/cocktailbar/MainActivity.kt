package com.example.cocktailbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.cocktailbar.presentation.screen.MainScreen
import com.example.cocktailbar.ui.theme.CocktailBarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailBarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Не успел сделать дизайн, фотографии, удаление конкретного элемента, возможность поделиться

                    //Ошибки
                    //Не правильно настроена база данных - нет строки для фото, не правильно сделана строка с рецептом
                    //не правильно сделана навигация - из мэйн экрана можно попасть обратно на экрон с редактированием
                    MainScreen()
                }
            }
        }
    }
}
