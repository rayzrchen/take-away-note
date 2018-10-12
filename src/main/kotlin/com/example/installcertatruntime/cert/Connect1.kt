package com.example.installcertatruntime.cert

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@RestController
class Connect1 {

    private val url = "https://www.google.com.hk"

    @GetMapping("/connect1")
    fun connectToWebsite() {
        val con = URL(url).openConnection() as HttpsURLConnection? ?: return

        //dump all cert info
        printHttpsCert(con)

        //dump all the content
        printContent(con)
    }

    private fun printHttpsCert(con: HttpsURLConnection) {
        println("""
            Response Code : ${con.responseCode}
            Cipher Suite : ${con.cipherSuite}

        """.trimIndent()
        )

        con.serverCertificates.size.also { println(it) }

        con.serverCertificates.forEach {
            println("""
                Cert Type : ${it.type}
                Cert Hash Code : ${it.hashCode()}
                Cert Public Key Algorithm : ${it.publicKey.algorithm}
                Cert Public Key Format : ${it.publicKey.format}

            """.trimIndent()
            )
        }

    }

    private fun printContent(con: HttpsURLConnection) {
        println("****** Content of the URL ********")
        con.inputStream.bufferedReader().lines().forEach { println(it) }
    }


    @GetMapping("connect2")
    fun test2() {

        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate>? {
                return null
            }

            override fun checkClientTrusted(certs: Array<java.security.cert.X509Certificate>, authType: String) {
            }

            override fun checkServerTrusted(certs: Array<java.security.cert.X509Certificate>, authType: String) {
            }
        })

        val sc = SSLContext.getInstance("TLS")
        sc.init(null, trustAllCerts, java.security.SecureRandom())
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)

        // Now you can access an https URL without having the certificate in the truststore
        printContent(URL(url).openConnection() as HttpsURLConnection)

    }

}
