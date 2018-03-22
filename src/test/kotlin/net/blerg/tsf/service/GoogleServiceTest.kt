package net.blerg.tsf.service

import org.jsoup.Jsoup
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class GoogleServiceTest {

    private val resource = this::class.java.classLoader.getResource("tsf.html").readText()
    private val doc = Jsoup.parse(resource)
    private val googleService = GoogleServiceImpl{_ -> doc}

    @Test
    fun first() = assertEquals("TSF Rádio Notícias", googleService.searchResult("", 0))

    @Test
    fun second() = assertEquals("Secret Footballer (@TSF) · Twitter", googleService.searchResult("", 1))

    @Test
    fun third() = assertEquals("Radio TSF | Radioonline.com.pt", googleService.searchResult("", 2))

    @Test
    fun fourth() = assertEquals("TSF (radio station) - Wikipedia", googleService.searchResult("", 3))

    @Test
    fun fifth() = assertEquals("TSF - Wikipedia", googleService.searchResult("", 4))

    @Test
    fun negativeOne() = assertEquals("", googleService.searchResult("", -1))

    @Test
    fun oneHundred() = assertEquals("", googleService.searchResult("", 100))
}