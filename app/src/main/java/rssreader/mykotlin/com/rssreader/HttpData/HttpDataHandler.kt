package rssreader.mykotlin.com.rssreader.HttpData


import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset

class HttpDataHandler{

    fun HttpDataHandler(){}
    fun  HttpGetData(urlstring:String):String
    {
        var stream = StreamObject.instance
        try {
          //  var urlstring:String="https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Frss.nytimes.com%2Fservices%2Fxml%2Frss%2Fnyt%2FScience.xml"
            val url = URL(urlstring)
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            if(urlConnection.responseCode == HttpURLConnection.HTTP_OK )
            {
                val inputStream: InputStream = BufferedInputStream(urlConnection.inputStream) as InputStream
                val r = BufferedReader(InputStreamReader(inputStream))
                val sb = StringBuilder()
                var line:String
                line = r.readLine()
                sb.append(line)
                stream = sb.toString()
            }
        }
        catch (E:Exception){}

        return stream
    }



}