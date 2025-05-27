package org.example.kmpmovies.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.kmpmovies.data.Movie
import org.example.kmpmovies.data.MoviesRepository

class HomeViewModel(
    private val repository: MoviesRepository
) : ViewModel() {
    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(
                loading = false,
                movies = repository.fetchPopularMovies()
            )
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}
