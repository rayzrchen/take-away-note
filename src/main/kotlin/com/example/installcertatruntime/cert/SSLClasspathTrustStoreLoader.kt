package com.example.installcertatruntime.cert

import java.security.KeyStore
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory

object SSLClasspathTrustStoreLoader {

    @Throws(Exception::class)
    fun setTrustStore(trustStore: String, password: String) {
        val trustManagerFactory = TrustManagerFactory.getInstance("X509")
        val keystore = KeyStore.getInstance(KeyStore.getDefaultType())
        val keystoreStream = SSLClasspathTrustStoreLoader::class.java.getResourceAsStream(trustStore)
        keystore.load(keystoreStream, password.toCharArray())
        trustManagerFactory.init(keystore)
        val trustManagers = trustManagerFactory.trustManagers
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustManagers, null)
        SSLContext.setDefault(sslContext)
    }

}