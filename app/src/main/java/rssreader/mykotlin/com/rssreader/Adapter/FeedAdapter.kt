package rssreader.mykotlin.com.rssreader.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rssreader.mykotlin.com.rssreader.Model.RssObject
import rssreader.mykotlin.com.rssreader.R

public class FeedAdapter(internal var context: Context, internal var postRssObject: RssObject):RecyclerView.Adapter<FeedViewHolder>(),View.OnClickListener
{
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FeedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row,parent,false)
        return FeedViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return  postRssObject.items.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.txt_Content.text = postRssObject.items[position].content.toString()
        holder.txt_pubdate.text = postRssObject.items[position].pubDate
        holder.txt_title.text = postRssObject.items[position].title


    }
}
