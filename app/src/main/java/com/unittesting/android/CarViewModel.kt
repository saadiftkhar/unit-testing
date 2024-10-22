package com.unittesting.android

class CarViewModel(private val carRepository: CarRepository) {

    fun fetchCarsByBrand(brand: String): List<Car> {
        val allCarList = carRepository.getCars()
        return allCarList.filter { car ->
            car.brand == brand
        }
    }
}