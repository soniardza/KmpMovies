package org.example.kmpmovies.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.kmpmovies.data.Movie
import org.example.kmpmovies.data.MoviesService
import org.example.kmpmovies.data.RemoteMovie

class HomeViewModel(
    private val moviesService: MoviesService
) : ViewModel() {
    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(
                loading = false,
                movies = moviesService.fetchPopularMovies().results.map {
                    it.toDomainMovie()
                }
            )
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}

private fun RemoteMovie.toDomainMovie() = Movie(
    id = id,
    title = title,
    poster = "https://image.tmdb.org/t/p/w500$posterPath"
)
