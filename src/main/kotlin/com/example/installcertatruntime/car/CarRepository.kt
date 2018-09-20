package com.example.installcertatruntime.car

import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<Car, Long>
