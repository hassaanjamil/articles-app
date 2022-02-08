package com.nytimes.app.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nytimes.app.data.remote.model.ResponseArticles
import com.nytimes.app.data.repository.MainRepository
import com.nytimes.app.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    private val articles = MutableLiveData<Resource<ResponseArticles>>()

    init {
        fetchMostPopularArticles()
    }

    private fun fetchMostPopularArticles() {
        viewModelScope.launch {
            articles.postValue(Resource.loading(null))
            try {
                val articlesFromApi = mainRepository.getMostPopularArticles()
                articles.postValue(Resource.success(articlesFromApi))
            } catch (e: Exception) {
                articles.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getMostPopularArticles(): LiveData<Resource<ResponseArticles>> {
        return articles
    }
}