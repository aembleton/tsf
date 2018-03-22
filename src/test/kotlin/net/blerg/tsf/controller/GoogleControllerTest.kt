package net.blerg.tsf.controller

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import net.blerg.tsf.service.GoogleService
import org.junit.jupiter.api.Test
import spark.Request
import org.junit.jupiter.api.Assertions.*

class GoogleControllerTest {

    @Test
    fun tsfRequest() {

        val googleService = mock<GoogleService> {
            on{searchResult("test search", 1)} doReturn "second result"
        }
        val request = mock<Request> {
            on{params(":query")} doReturn "test search"
        }

        val googleController = GoogleController(googleService)
        val result = googleController.getSecondResult(request)

        assertEquals("second result", result)

    }
}