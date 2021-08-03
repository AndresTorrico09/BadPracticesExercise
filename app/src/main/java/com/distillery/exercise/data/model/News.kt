package com.distillery.exercise.data.model

import java.io.Serializable
import java.util.*

class News(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Date,
    val content: String
): Serializable

class Source(val name: String): Serializable