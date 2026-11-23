package com.example.glanceexample.glance

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

object PriceDataRepo {

    var ticker: String = "GOOGL"

    private var previousPrice: Float = 0f

    var change: Int = 0
        private set

    private var _currentPrice: MutableStateFlow<Float> = MutableStateFlow(0f)
    val currentPrice: StateFlow<Float> get() = _currentPrice

    fun update() {
        previousPrice = currentPrice.value
        _currentPrice.value = Random.nextInt(20, 35) + Random.nextFloat()
        change = if (previousPrice == 0f) {
            0
        } else {
            ((_currentPrice.value - previousPrice) / previousPrice * 100).toInt()
        }
    }
}