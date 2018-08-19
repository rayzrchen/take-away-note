package com.example.installcertatruntime.cert;

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
