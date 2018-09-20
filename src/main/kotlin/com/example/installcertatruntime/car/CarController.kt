package com.example.installcertatruntime.car

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/cars")
class CarController(private val carService: CarService) {

    @GetMapping("")
    fun all(): List<*> {
        return carService.all()
    }

    @PostMapping("")
    fun create(@RequestBody car: Car): Car {
        return carService.create(car)
    }

}
