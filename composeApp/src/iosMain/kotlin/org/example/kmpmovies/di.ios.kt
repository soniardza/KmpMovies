package org.example.kmpmovies

import org.example.kmpmovies.data.IosRegionDataSource
import org.example.kmpmovies.data.RegionDataSource
import org.example.kmpmovies.data.database.getDatabaseBuilder
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val nativeModule = module {
    single { getDatabaseBuilder() }
    factoryOf(::IosRegionDataSource) bind RegionDataSource::class
}
