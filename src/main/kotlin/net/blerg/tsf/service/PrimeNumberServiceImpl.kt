package net.blerg.tsf.service

import java.math.BigInteger
import kotlin.math.roundToInt

class PrimeNumberServiceImpl : PrimeNumberService {

    override fun trial(max:Int) = (1..max).filter{trialDivision(it)}
    override fun wilson(max:Int) = (1..max).filter{ wilsons(it) }

    private fun trialDivision(input:Int):Boolean {
        val sqrRoot = input.sqrt()
        return input > 1 && !(2..sqrRoot).any { input % it == 0 }
    }

    private fun wilsons(input:Int):Boolean {
        if (input < 2) return false
        val factorial = (input - 1).factorial()
        return factorial % input.toBigInteger() == input.toBigInteger() - BigInteger.ONE
    }

    private fun Int.sqrt() = Math.sqrt(this.toDouble()).roundToInt()

    private fun Int.factorial() = (1..this).map { it.toBigInteger() }.reduce{a,b -> a*b}

}