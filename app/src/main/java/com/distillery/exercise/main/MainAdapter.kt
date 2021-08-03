package com.distillery.exercise.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.distillery.exercise.R
import com.distillery.exercise.data.model.News

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    private val items = ArrayList<News>()

    fun setItems(items: ArrayList<News>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(items[position])
}

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var itemNews: News
    private val textViewTitle: TextView = view.findViewById(R.id.tv_title)
    private val textViewSource: TextView = view.findViewById(R.id.tv_source)
    
    fun bind(item: News) {
        this.itemNews = item
        textViewTitle.text = item.title
        textViewSource.text = item.source.name
    }
}
