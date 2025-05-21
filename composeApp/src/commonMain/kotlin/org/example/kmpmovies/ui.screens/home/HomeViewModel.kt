package org.example.kmpmovies.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.kmpmovies.Movie
import org.example.kmpmovies.movies

class HomeViewModel : ViewModel() {
    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            delay(1000)
            state = UiState(loading = false, movies = movies)
        }
    }
    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}
