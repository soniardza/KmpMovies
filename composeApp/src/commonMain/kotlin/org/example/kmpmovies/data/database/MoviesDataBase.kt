package org.example.kmpmovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.example.kmpmovies.data.Movie

const val DATABASE_NAME = "movies.db"

interface DB {
    fun clearAllTables() // debido a un bug en el alpha de room, se implementa esta funcion para poder compilar
}

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDataBase : RoomDatabase(), DB {
    abstract fun moviesDao(): MoviesDao

    override fun clearAllTables() {}
}