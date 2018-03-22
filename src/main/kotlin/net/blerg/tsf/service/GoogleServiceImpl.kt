package net.blerg.tsf.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.apache.logging.log4j.*

const val googleUrl = "https://www.google.co.uk/search?q="
const val cssQuery = ".r"
private val log = LogManager.getLogger(GoogleServiceImpl::class.java.name)

class GoogleServiceImpl(private val connectionFun: (url:String) -> Document = {url:String -> Jsoup.connect(url).get()}) : GoogleService {

    override fun searchResult(query: String, index: Int): String {
        val doc = connectionFun(googleUrl + query)
        val results = doc.select(cssQuery).map { it.text() }

        try {
            return results[index]
        } catch (e:IndexOutOfBoundsException) {
            log.error("Could not retrieve result with index $index as there were only ${results.size} results for the Google query '$query'.")
        }

        return ""
    }

}