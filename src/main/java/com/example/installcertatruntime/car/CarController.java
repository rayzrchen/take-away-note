package com.example.installcertatruntime.car;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public List<Car> all() {
        return carService.all();

    }

    @PostMapping("")
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

}
