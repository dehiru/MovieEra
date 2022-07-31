package com.example.movieera.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("all.json")
    suspend fun getMovies(
        @Query("offset") offset: Int,
        @Query("api-key") apiKey: String
    ): FirstLevelNetworkResponse
}