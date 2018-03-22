package net.blerg.tsf.service

interface GoogleService {
    fun searchResult(query: String, index: Int): String
}