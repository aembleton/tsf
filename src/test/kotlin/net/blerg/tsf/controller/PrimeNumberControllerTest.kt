package net.blerg.tsf.controller

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import net.blerg.tsf.service.PrimeNumberService
import org.junit.jupiter.api.Test
import spark.Request
import org.junit.jupiter.api.Assertions.*


class PrimeNumberControllerTest {

    private val primeNumberService = mock<PrimeNumberService> {
        on{trial(10)} doReturn listOf(2, 3, 5, 7)
        on{wilson(10)} doReturn listOf(2, 3, 5, 7)
    }

    private val request = mock<Request> {
        on{params(":max")} doReturn "10"
    }

    private val primeNumberController = PrimeNumberController(primeNumberService)

    @Test
    fun trial() = assertEquals(listOf(2, 3, 5, 7), primeNumberController.trial(request))

    @Test
    fun wilson() = assertEquals(listOf(2, 3, 5, 7), primeNumberController.wilson(request))
}