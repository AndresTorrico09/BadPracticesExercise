package com.distillery.exercise.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.distillery.exercise.R
import com.distillery.exercise.data.model.News
import com.distillery.exercise.detail.DetailActivity
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity(), MainAdapter.NewsItemListener {
    lateinit var mainViewModel: MainViewModel
    val adapter = MainAdapter(this)

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

    override fun onClickedNews(news: News) {
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra("newsSelected", news)
        startActivity(intent)
    }
}