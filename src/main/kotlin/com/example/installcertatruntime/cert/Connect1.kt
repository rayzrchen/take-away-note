package com.example.installcertatruntime.cert

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@RestController
class Connect1 {

    @GetMapping("/connect1")
    fun connectToWebsite(): String {


        val https_url = "https://www.hsbc.com/"
        val url: URL
        try {

            url = URL(https_url)
            val con = url.openConnection() as HttpsURLConnection

            //dumpl all cert info
            print_https_cert(con)

            //dump all the content
            print_content(con)

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return ""
    }

    private fun print_https_cert(con: HttpsURLConnection?) {

        if (con != null) {

            try {

                println("Response Code : " + con.responseCode)
                println("Cipher Suite : " + con.cipherSuite)
                println("\n")

                val certs = con.serverCertificates
                for (cert in certs) {
                    println("Cert Type : " + cert.type)
                    println("Cert Hash Code : " + cert.hashCode())
                    println("Cert Public Key Algorithm : " + cert.publicKey.algorithm)
                    println("Cert Public Key Format : " + cert.publicKey.format)
                    println("\n")
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

    }

    private fun print_content(con: HttpsURLConnection?) {
        if (con != null) {

            try {

                println("****** Content of the URL ********")
                val br = BufferedReader(
                        InputStreamReader(con.inputStream))

                var input: String



                while (true){

                    input = br.readLine()

                    if (input == null) {
                        break
                    }

                    println(input)

                }

                br.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

    }


    @GetMapping("connect2")
    fun test2(): String {

        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate>? {
                return null
            }

            override fun checkClientTrusted(
                    certs: Array<java.security.cert.X509Certificate>, authType: String) {
            }

            override fun checkServerTrusted(
                    certs: Array<java.security.cert.X509Certificate>, authType: String) {
            }
        })

        // Install the all-trusting trust manager
        try {
            //            SSLContext sc = SSLContext.getInstance("SSL");
            val sc = SSLContext.getInstance("TLS")
            sc.init(null, trustAllCerts, java.security.SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
        } catch (e: Exception) {
        }

        // Now you can access an https URL without having the certificate in the truststore
        try {
            val url = URL("https://www.hsbc.com.hk")

            val urlConnection = url.openConnection()

            print_content(urlConnection as HttpsURLConnection)

        } catch (e: Exception) {
        }


        return ""
    }

}
