package com.example.installcertatruntime.cert

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("try")
class TryShortCuts(private val tryService: TryService) {

    fun test1(concate: (String, String) -> String): String {
        val s1 = "D:\\develop\\installcertatruntime\\src\\main\\java\\com\\example\\installcertatruntime\\cert\\TryShortCuts.java"
        val s = "com/example/install_cert_at_runtime/cert/TryShortCuts.java:21"
        val s2 = concate(s1, s)

        val s3 = concate("1", s2)
        val s4 = s3 + "aaaa"

        tryService.greeting()
        tryService.sayHi()



        return s3
    }


    fun test2() {
        test1 { s1, s2 -> s1 + s2 }
    }

    private fun concatString(s1: String, s: String): String {
        return s1 + s
    }


}
