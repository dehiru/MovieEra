package com.example.movieera.di

import com.example.movieera.data.MoviePagingSource
import com.example.movieera.data.MovieRepository
import com.example.movieera.network.MovieApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/reviews/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApiService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
            .create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePagingSource(api: MovieApiService): MoviePagingSource {
        return MoviePagingSource(api)
    }

    @Provides
    @Singleton
    fun provideRepository(api: MovieApiService): MovieRepository {
        return MovieRepository(api)
    }
}