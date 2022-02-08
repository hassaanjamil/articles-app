package com.nytimes.app.data.remote

import com.nytimes.app.data.remote.model.ResponseArticles


interface ApiHelper {
    suspend fun getMostPopularArticles(): ResponseArticles
}