package com.distillery.exercise

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.distillery.exercise.data.NewsAPI
import com.distillery.exercise.data.model.News
import com.distillery.exercise.data.model.NewsResponse
import com.distillery.exercise.main.MainViewModel
import com.distillery.exercise.util.MainCoroutineRule
import com.distillery.exercise.util.getOrAwaitValue
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var newsAPI: NewsAPI
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        newsAPI = mock()
        mainViewModel = MainViewModel()
    }

    @Test
    fun getNewsTest() = runBlocking {
        val mockExpected = mock<ArrayList<News>>()
        val mockNewsSuccess = Response.success(NewsResponse(mockExpected))

        whenever(newsAPI.searchNews("apple")).thenReturn(mockNewsSuccess)
        mainViewModel.getNews("apple")

        Assert.assertTrue(
            mainViewModel.news.getOrAwaitValue() is ArrayList<News>
        )
    }
}