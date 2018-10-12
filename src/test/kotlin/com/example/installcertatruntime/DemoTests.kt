package com.example.installcertatruntime


import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoTests {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun test1() {
        val forEntity = testRestTemplate.getForEntity("/api/v1/cars/demo", String::class.java)
        assertThat(forEntity.statusCode).isEqualTo(HttpStatus.OK)
    }
}

