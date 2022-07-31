package com.example.movieera.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieera.network.Movie
import com.example.movieera.network.MovieApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val API_KEY = "5qunVa4UITxtAzcpCaiGcOUpjmCPekKW"

//Number of movies returned in the API response results array.
//Declared by Movie Reviews API creators
private const val MOVIES_NUM_IN_RESPONSE = 20

class MoviePagingSource @Inject constructor(
    private val apiService: MovieApiService
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val pageNumber = params.key ?: 0
        val offset = pageNumber * MOVIES_NUM_IN_RESPONSE
        return try {
            val response = apiService.getMovies(offset = offset, apiKey = API_KEY)
            val prevKey = if (pageNumber > 0) pageNumber - 1 else null
            val nextKey = if (response.hasMore) pageNumber + 1 else null
            LoadResult.Page(
                data = response.results,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            e.printStackTrace()
            LoadResult.Error(e)
        } catch (e: HttpException) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}