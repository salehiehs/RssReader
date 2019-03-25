package rssreader.mykotlin.com.rssreader.HttpData

import org.junit.Test

import org.junit.Assert.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL


class HttpDataHandlerTest {


    @Test
    fun httpGetData() {
        try {
            var stream = StreamObject.instance
          //  var stream:String = "ss"
            var urlstring:String="https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Frss.nytimes.com%2Fservices%2Fxml%2Frss%2Fnyt%2FScience.xml"
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
              //  while ( r.readLine() != null)
                //{

                  //  sb.append(line)
                    stream = sb.toString()
                  //  urlConnection.disconnect()

                //}
            }

        }
        catch (E:Exception){}


    }


}