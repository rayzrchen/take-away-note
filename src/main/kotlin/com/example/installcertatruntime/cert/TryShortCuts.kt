package com.example.installcertatruntime.cert

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["try"])
class TryShortCuts(private val tryService: TryService) {


    @GetMapping("")
    fun test1(): String {
        val s1 = "D:\\develop\\installcertatruntime\\src\\main\\java\\com\\example\\installcertatruntime\\cert\\TryShortCuts.java"
        val s = "com/example/install_cert_at_runtime/cert/TryShortCuts.java:21"

        val s2 = concatString(s1, s)

        val s3 = concatString("1", s2)
        val s4 = s3 + "aaaa"

        tryService.greeting()
        tryService.sayHi()



        return s3
    }


    private fun concatString(s1: String, s: String): String {
        return s1 + s
    }

}
