package com.example.installcertatruntime

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class InstallCertAtRuntimeApplication


fun main(args: Array<String>) {
    SpringApplication.run(InstallCertAtRuntimeApplication::class.java, *args)
}

