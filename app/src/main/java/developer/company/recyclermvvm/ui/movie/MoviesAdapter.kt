package developer.company.recyclermvvm.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import developer.company.recyclermvvm.R
import developer.company.recyclermvvm.data.models.Movies
import developer.company.recyclermvvm.databinding.RecyclerviewMovieBinding

class MoviesAdapter(private val movies: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate<RecyclerviewMovieBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movies[position]
    }

    inner class MoviesViewHolder(val recyclerviewMovieBinding: RecyclerviewMovieBinding) :
        RecyclerView.ViewHolder(recyclerviewMovieBinding.root) {

    }

}