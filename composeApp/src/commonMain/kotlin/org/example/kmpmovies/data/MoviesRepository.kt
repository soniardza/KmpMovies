package org.example.kmpmovies.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import org.example.kmpmovies.data.database.MoviesDao
import org.example.kmpmovies.data.remote.MoviesService
import org.example.kmpmovies.data.remote.RemoteMovie

class MoviesRepository(
    private val moviesService: MoviesService,
    private val moviesDao: MoviesDao,
    private val regionRepository: RegionRepository
) {
    val movies: Flow<List<Movie>> = moviesDao.fetchPopularMovies().onEach { movies ->
        if (movies.isEmpty()) {
            val popularMovies = moviesService
                .fetchPopularMovies(
                    regionRepository.fetchRegion()
                )
                .results.map { it.toDomainMovie() }
            moviesDao.save(popularMovies)
        }
    }

    suspend fun fetchMoviesById(id: Int): Flow<Movie?> =
        moviesDao.fetchMovieById(id).onEach { movie ->
            if (movie == null) {
                val remoteMovie = moviesService.fetchMoviesById(id).toDomainMovie()
                moviesDao.save(listOf(remoteMovie))
            }

        }

    suspend fun toggleFavorite(movie: Movie) {
        moviesDao.save(listOf(movie.copy(isFavorite = !movie.isFavorite)))
    }
}

private fun RemoteMovie.toDomainMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    releaseDate = releaseDate,
    poster = "https://image.tmdb.org/t/p/w500$posterPath",
    backdrop = backdropPath?.let { "https://image.tmdb.org/t/p/w780/$it" },
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    popularity = popularity,
    voteAverage = voteAverage,
    isFavorite = false
)
