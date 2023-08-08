package com.example.cocktailbar.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        CocktailInfo::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun Dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: CocktailDatabase? = null

        fun getInstance(context: Context): CocktailDatabase {
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                CocktailDatabase::class.java,
                "cocktail_database"
            ).build().also { INSTANCE = it }
        }
    }
}

