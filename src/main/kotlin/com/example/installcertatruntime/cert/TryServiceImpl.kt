package com.example.installcertatruntime.cert

import org.springframework.stereotype.Service

@Service
class TryServiceImpl : TryService {

    override fun sayHi(): String {
        return "hi"
    }

    override fun greeting(): String {
        return "greeting"
    }
}
