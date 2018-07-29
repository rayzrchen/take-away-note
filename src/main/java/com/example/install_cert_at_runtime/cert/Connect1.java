package com.example.install_cert_at_runtime.cert;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;

@RestController
public class Connect1 {

    @GetMapping("/connect1")
    public String connectToWebsite() {


        String https_url = "https://www.hsbc.com/";
        URL url;
        try {

            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            //dumpl all cert info
            print_https_cert(con);

            //dump all the content
            print_content(con);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private void print_https_cert(HttpsURLConnection con) {

        if (con != null) {

            try {

                System.out.println("Response Code : " + con.getResponseCode());
                System.out.println("Cipher Suite : " + con.getCipherSuite());
                System.out.println("\n");

                Certificate[] certs = con.getServerCertificates();
                for (Certificate cert : certs) {
                    System.out.println("Cert Type : " + cert.getType());
                    System.out.println("Cert Hash Code : " + cert.hashCode());
                    System.out.println("Cert Public Key Algorithm : "
                            + cert.getPublicKey().getAlgorithm());
                    System.out.println("Cert Public Key Format : "
                            + cert.getPublicKey().getFormat());
                    System.out.println("\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private void print_content(HttpsURLConnection con) {
        if (con != null) {

            try {

                System.out.println("****** Content of the URL ********");
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(con.getInputStream()));

                String input;

                while ((input = br.readLine()) != null) {
                    System.out.println(input);
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    @GetMapping("connect2")
    public String test2() {

        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }

        // Now you can access an https URL without having the certificate in the truststore
        try {
            URL url = new URL("https://www.hsbc.com.hk");

            URLConnection urlConnection = url.openConnection();

            print_content((HttpsURLConnection) urlConnection);

        } catch (Exception e) {
        }


        return "";
    }

}
