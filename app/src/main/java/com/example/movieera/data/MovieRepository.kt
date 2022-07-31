package com.example.movieera.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.movieera.network.Movie
import com.example.movieera.network.MovieApiService

class MovieRepository(private val apiService: MovieApiService) {

    suspend fun getMovieList(): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(apiService)
            }
        ).liveData
    }

}