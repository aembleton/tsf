package net.blerg.tsf.controller

import net.blerg.tsf.service.PrimeNumberService
import net.blerg.tsf.service.PrimeNumberServiceImpl
import spark.Request
import spark.Spark

class PrimeNumberController(private val primeNumberService: PrimeNumberService = PrimeNumberServiceImpl()) {

    fun trial(request: Request):List<Int> = primeNumber(request, primeNumberService::trial)

    fun wilson(request: Request):List<Int> = primeNumber(request, primeNumberService::wilson)

    private fun primeNumber(request: Request, primeFun: (max:Int) -> List<Int>):List<Int> {
        try {
            val max = Integer.parseInt(request.params(":max"))
            return primeFun(max)
        } catch(e:NumberFormatException) {
            Spark.halt(400, "The max value must be a number.  For example /prime/4/trial")
        }
        return emptyList()
    }
}