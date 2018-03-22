package net.blerg.tsf

import net.blerg.tsf.controller.GoogleController
import net.blerg.tsf.controller.PrimeNumberController
import spark.Spark.*

const val startupLogo = """
  _______ _____ ______
 |__   __/ ____|  ____|
    | | | (___ | |__
    | |  \___ \|  __|
    | |  ____) | |
    |_| |_____/|_|

                       """

fun main(args: Array<String>) {
    println(startupLogo)

    val googleController = GoogleController()
    val primeNumberController = PrimeNumberController()

    path("/prime/:max") {
        get("/trial") {req,_ -> primeNumberController.trial(req)}
        get("/wilson") {req,_ -> primeNumberController.wilson(req)}
    }
    get("/google/:query") {req,_ -> googleController.getSecondResult(req)}
}

