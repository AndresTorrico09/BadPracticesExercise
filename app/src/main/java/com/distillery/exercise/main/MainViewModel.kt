package com.distillery.exercise.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.distillery.exercise.data.DependencyProvider
import com.distillery.exercise.data.NewsAPI
import com.distillery.exercise.data.model.News
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class MainViewModel : ViewModel() {
    private val newsAPI = DependencyProvider.provideService(NewsAPI::class.java)
    val news = MutableLiveData<ArrayList<News>>()

    fun getNews(s: String) = GlobalScope.launch {
        val response = newsAPI.searchNews(s)

        if (response.isSuccessful && response.body() != null) {
            withContext(Dispatchers.Main) {
                news.value = response.body()!!.articles
            }
        } else {
            withContext(Dispatchers.Main) {
                news.value = null
            }
        }
    }

}