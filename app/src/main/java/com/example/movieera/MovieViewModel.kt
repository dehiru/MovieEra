package com.example.movieera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movieera.data.MovieRepository
import com.example.movieera.network.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {

    private val _movieList = MutableLiveData<PagingData<Movie>>()

    suspend fun getMovieList(): LiveData<PagingData<Movie>> {
        val response = repository.getMovieList().cachedIn(viewModelScope)
        _movieList.value = response.value
        return response
    }

}