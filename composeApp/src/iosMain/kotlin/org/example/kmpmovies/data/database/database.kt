package org.example.kmpmovies.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<MoviesDataBase> {
    val dbFilePath = NSHomeDirectory() + "/$DATABASE_NAME"
    return Room.databaseBuilder<MoviesDataBase>(
        name = dbFilePath,
        factory = { MoviesDataBase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
}
