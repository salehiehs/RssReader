package rssreader.mykotlin.com.rssreader.Model

data class Feed(
        val author: String,
        val description: String,
        val image: String,
        val link: String,
        val title: String,
        val url: String
)