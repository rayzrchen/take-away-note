package com.example.installcertatruntime.car

import org.springframework.stereotype.Service

@Service
class CarService(private val carRepository: CarRepository) {

    fun all(): List<Car> {
        return carRepository.findAll()
    }

    fun create(car: Car): Car {

        val car1 = Car(id = 1, color = "red", licensePlate = "1")

        val mutableListOf = mutableListOf(1, 2, 3)

        (0..10).forEach { println(it) }

        (0..10).forEach { Car(it.toLong(), "A", "b") }


        return carRepository.save(car)

    }
}
