package com.distillery.exercise.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.distillery.exercise.R
import com.distillery.exercise.data.model.News

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get views
        val tvTitle: TextView = findViewById(R.id.tv_title)
        val tvSource: TextView = findViewById(R.id.tv_source)
        val tvAuthor: TextView = findViewById(R.id.tv_author)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val tvUrl: TextView = findViewById(R.id.tv_url)

        //set views values
        val newsSelected = intent.getSerializableExtra("newsSelected") as News
        tvTitle.text = newsSelected.title
        tvSource.text = newsSelected.source.name
        tvAuthor.text = newsSelected.author
        tvDescription.text = newsSelected.description
        tvUrl.text = newsSelected.url
    }
}