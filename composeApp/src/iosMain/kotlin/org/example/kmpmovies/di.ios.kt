package org.example.kmpmovies

import org.example.kmpmovies.data.database.getDatabaseBuilder
import org.koin.dsl.module

actual val nativeModule = module {
    single { getDatabaseBuilder() }
}
