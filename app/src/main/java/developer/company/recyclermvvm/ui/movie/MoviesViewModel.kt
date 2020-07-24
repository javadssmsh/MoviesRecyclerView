package developer.company.recyclermvvm.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import developer.company.recyclermvvm.utils.Coroutines
import developer.company.recyclermvvm.data.models.Movies
import developer.company.recyclermvvm.data.repositories.MoviesRepository
import kotlinx.coroutines.Job

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {

    private lateinit var job:Job

    private val _movies = MutableLiveData<List<Movies>>()
    val movies: LiveData<List<Movies>>
        get() = _movies
    fun getMovies(){
        job = Coroutines.ioTheMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
