package net.blerg.tsf.controller

import net.blerg.tsf.service.GoogleService
import net.blerg.tsf.service.GoogleServiceImpl
import spark.Request

class GoogleController(private val googleService: GoogleService = GoogleServiceImpl()) {

    fun getSecondResult(request: Request): String {
        val query = request.params(":query")
        return googleService.searchResult(query, 1)
    }
}