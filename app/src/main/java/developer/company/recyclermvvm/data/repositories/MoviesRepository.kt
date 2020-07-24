package developer.company.recyclermvvm.data.repositories

import developer.company.recyclermvvm.data.network.MoviesApi

class MoviesRepository(private val api: MoviesApi):
    SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}