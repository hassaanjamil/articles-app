package com.nytimes.app.data.remote

import com.nytimes.app.BuildConfig
import com.nytimes.app.data.remote.model.ResponseArticles
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{section}/{period}.json")
    suspend fun getMostPopularArticles(
        @Path("section") section: String,
        @Path("period") period: String,
        @Query("api-key") apiKey: String = BuildConfig.API_KEY,
    ): ResponseArticles
}