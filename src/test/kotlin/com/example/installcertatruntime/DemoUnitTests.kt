package com.example.installcertatruntime

import com.example.installcertatruntime.car.Car
import com.example.installcertatruntime.car.CarController
import com.example.installcertatruntime.car.CarService
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DemoUnitTests {

    @InjectMocks
    lateinit var carController: CarController

    @Mock
    lateinit var carService: CarService

    @Test
    fun test1() {
        val result = listOf(Car(), Car())
        Mockito.`when`(carService.all()).thenReturn(result)
        val demo = carController.all()
        Assertions.assertThat(demo.size).isEqualTo(2)
    }
}