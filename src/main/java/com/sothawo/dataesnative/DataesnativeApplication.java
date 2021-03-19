package com.sothawo.dataesnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.TypeHint;

@TypeHint(types = PersonCustomRepositoryImpl.class)
@SpringBootApplication
public class DataesnativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataesnativeApplication.class, args);
    }

}
