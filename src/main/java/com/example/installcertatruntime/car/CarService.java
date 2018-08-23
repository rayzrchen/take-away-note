package com.example.installcertatruntime.car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> all() {
        return carRepository.findAll();
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }
}
