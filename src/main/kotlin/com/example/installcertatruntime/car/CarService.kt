package com.example.installcertatruntime.car

import org.springframework.stereotype.Service

@Service
class CarService(private val carRepository: CarRepository) {

    fun all(): List<Car> {
        return carRepository.findAll()
    }

    fun create(car: Car): Car {
        return carRepository.save(car)
    }
}
