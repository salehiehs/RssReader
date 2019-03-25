package rssreader.mykotlin.com.rssreader.Model

data class RssObject(
        val feed: Feed,
        val items: List<Item>,
        val status: String
)