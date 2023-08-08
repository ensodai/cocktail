package com.example.cocktailbar.di

import android.content.Context
import com.example.cocktailbar.data.Repository
import com.example.cocktailbar.data.dataBase.CocktailDatabase
import com.example.cocktailbar.data.dataBase.Dao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context): Dao {
        return CocktailDatabase.getInstance(context).Dao()
    }

    @Provides
    @Singleton
    fun provideRepository(dao: Dao): Repository {
        return Repository(dao)
    }
}