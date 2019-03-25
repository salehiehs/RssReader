package rssreader.mykotlin.com.rssreader.HttpData

object StreamObject {
    private var ourInstance:String?=null
    val instance:String
    get(){
        if(ourInstance==null)
            ourInstance = ""
        return ourInstance!!
    }

}