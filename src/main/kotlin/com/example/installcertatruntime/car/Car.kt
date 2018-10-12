package com.example.installcertatruntime.car

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Car(
        @Id
        @GeneratedValue
        var id: UUID = UUID(0, 0),

        var licensePlate: String = "",

        var color: String = ""

)

interface CarRepository : JpaRepository<Car, Long>


@RestController
@RequestMapping("api/v1/cars")
class CarController(private val carService: CarService) {

    @GetMapping("")
    fun all(): List<Car> {
        return carService.all()
    }

    @PostMapping("")
    fun create(@RequestBody car: Car): Car {
        return carService.create(car)
    }


    @GetMapping("demo")
    fun demo() = "hello, demo"


}

@Service
class CarService(private val carRepository: CarRepository) {

    fun all(): List<Car> {
        return carRepository.findAll()
    }

    fun create(car: Car): Car = carRepository.save(car)
}
