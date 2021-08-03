package com.distillery.exercise.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.distillery.exercise.R
import com.distillery.exercise.data.model.News
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //Set recycler view
        val recyclerView: RecyclerView = findViewById(R.id.rv_news)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        //call viewmodel
        mainViewModel.getNews("apple")

        //observe livedata
        mainViewModel.news.observe(this, { news ->
            showNews(news)
        })
    }

    private fun showNews(news: ArrayList<News>) {
        adapter.setItems(news)
    }
}