package com.distillery.exercise.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.distillery.exercise.R
import com.distillery.exercise.data.model.News

class MainAdapter (private val listener: NewsItemListener): RecyclerView.Adapter<MainViewHolder>() {

    interface NewsItemListener {
        fun onClickedNews(news: News)
    }

    private val items = ArrayList<News>()

    fun setItems(items: ArrayList<News>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(view, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(items[position])
}

class MainViewHolder(view: View, private val listener: MainAdapter.NewsItemListener) :
    RecyclerView.ViewHolder(view), View.OnClickListener  {

    private lateinit var itemNews: News
    private val textViewTitle: TextView = view.findViewById(R.id.tv_title)
    private val textViewSource: TextView = view.findViewById(R.id.tv_source)

    init {
        view.rootView.setOnClickListener(this)
    }


    fun bind(item: News) {
        this.itemNews = item
        textViewTitle.text = item.title
        textViewSource.text = item.source.name
    }

    override fun onClick(v: View?) {
        listener.onClickedNews(itemNews)
    }
}
