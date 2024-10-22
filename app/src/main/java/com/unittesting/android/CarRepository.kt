package com.unittesting.android

open class CarRepository {
    open fun getCars(): List<Car> {
        val mercedes = Car("mercedes", 2019)
        return mutableListOf(mercedes)
    }
}