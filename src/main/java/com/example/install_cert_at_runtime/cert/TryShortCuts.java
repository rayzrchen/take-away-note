package com.example.install_cert_at_runtime.cert;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "try")
public class TryShortCuts {

    private final TryService tryService;

    public TryShortCuts(TryService tryService) {
        this.tryService = tryService;
    }


    @GetMapping("")
    public String test1() {
        String s1 = "D:\\develop\\install_cert_at_runtime\\src\\main\\java\\com\\example\\install_cert_at_runtime\\cert\\TryShortCuts.java";
        String s = "com/example/install_cert_at_runtime/cert/TryShortCuts.java:21";

        String s2 = concatString(s1, s);

        String s3 = concatString("1", s2);

        return s3;
    }

    private String concatString(String s1, String s) {
        return s1 + s;
    }

}
