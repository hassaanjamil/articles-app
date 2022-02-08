package com.nytimes.app.data.repository

import com.nytimes.app.data.remote.ApiHelper
import com.nytimes.app.data.remote.model.ResponseArticles
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper,
) {
    suspend fun getMostPopularArticles(): ResponseArticles {
        return apiHelper.getMostPopularArticles()
    }
}