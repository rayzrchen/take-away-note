package com.example.install_cert_at_runtime.cert;

import org.springframework.stereotype.Service;

@Service
public class TryServiceImpl implements TryService {

    @Override
    public String sayHi() {
        return "hi";
    }

    @Override
    public String greeting() {
        return "greeting";
    }
}
