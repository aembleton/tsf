package net.blerg.tsf.service

interface PrimeNumberService {
    fun trial(max: Int): List<Int>
    fun wilson(max: Int): List<Int>
}