package rssreader.mykotlin.com.rssreader.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.row.view.*

class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener
{
    override fun onClick(v: View?) {

    }

    val txt_title = itemView.txtTitle
    val txt_Content = itemView.txtContent
    val txt_pubdate = itemView.txtPubdata
}