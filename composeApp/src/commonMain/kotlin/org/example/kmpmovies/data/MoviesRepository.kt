package org.example.kmpmovies.data

class MoviesRepository(private val moviesService: MoviesService) {
    suspend fun fetchPopularMovies(): List<Movie> {
        return moviesService.fetchPopularMovies().results.map {
            it.toDomainMovie()
        }
    }

    suspend fun fetchMoviesById(id: Int): Movie {
        return moviesService.fetchMoviesById(id).toDomainMovie()
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
    voteAverage = voteAverage
)
