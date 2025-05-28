package org.example.kmpmovies

import androidx.compose.ui.window.ComposeUIViewController
import org.example.kmpmovies.data.database.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController {
    val database = getDatabaseBuilder().build()
    App(database.moviesDao())
}
