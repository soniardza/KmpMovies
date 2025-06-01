package org.example.kmpmovies

import androidx.room.RoomDatabase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.kmpmovies.data.MoviesRepository
import org.example.kmpmovies.data.MoviesService
import org.example.kmpmovies.data.database.MoviesDao
import org.example.kmpmovies.data.database.MoviesDataBase
import org.example.kmpmovies.ui.screens.detail.DetailViewModel
import org.example.kmpmovies.ui.screens.home.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.KoinAppDeclaration

val appModule = module {
    single(named("apikey")) { BuildConfig.API_KEY }
    single<MoviesDao> {
        val dbBuilder = get<RoomDatabase.Builder<MoviesDataBase>>()
        dbBuilder.build().moviesDao()
    }
}

val dataModule = module {
    factoryOf(::MoviesRepository)
    factoryOf(::MoviesService)
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys =
                        true // Es para no recibir una excepcion ya que no se parcea el JSON completo
                })
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "api.themoviedb.org"
                    parameters.append("api_key", BuildConfig.API_KEY)
                }
            }
        }
    }
}

val viewModelsModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
}

expect val nativeModule: Module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule, dataModule, viewModelsModule, nativeModule)
    }
}
