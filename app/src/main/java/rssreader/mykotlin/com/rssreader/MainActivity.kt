package rssreader.mykotlin.com.rssreader

import android.app.ProgressDialog
import android.graphics.drawable.GradientDrawable
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import rssreader.mykotlin.com.rssreader.Adapter.FeedAdapter
import rssreader.mykotlin.com.rssreader.HttpData.HttpDataHandler
import rssreader.mykotlin.com.rssreader.Model.RssObject
import rssreader.mykotlin.com.rssreader.R.id.recyclerview
import rssreader.mykotlin.com.rssreader.R.id.toolbar

class MainActivity : AppCompatActivity() {

    private val RSS_Link = "https://www.nytimes.com/services/xml/rss/nyt/Science.xml"
    private val RSS_to_JSON = "https://api.rss2json.com/v1/api.json?rss_url="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="News"
        setSupportActionBar(toolbar)
        val linearLayoutManager = LinearLayoutManager(baseContext,LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager = linearLayoutManager

        loadRSS()



    }

    private fun loadRSS() {
        var loadRSSAsync = object:AsyncTask<String,String,String>(){
            internal var mDialog = ProgressDialog(this@MainActivity)
            override fun onPostExecute(result: String?) {
                mDialog.dismiss()
                var rssObject:RssObject
                rssObject = Gson().fromJson<RssObject>(result,RssObject::class.java!!)
                val adapter = FeedAdapter(baseContext,rssObject)
                recyclerview.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun doInBackground(vararg params: String): String {
                val result:String
                val http = HttpDataHandler()
                result = http.HttpGetData(params[0])
                return result
            }

            override fun onPreExecute() {
               mDialog.setMessage("Please wait...")
               mDialog.show()
            }


        }
        val url_get_data = StringBuilder(RSS_to_JSON)
        url_get_data.append(RSS_Link)
        loadRSSAsync.execute(url_get_data.toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(item.itemId == R.id.menu_refresh)
           loadRSS()
        return true
    }
}

