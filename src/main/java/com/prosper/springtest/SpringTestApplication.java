package com.prosper.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by gpanneerselvam on 4/18/17.
 */
@SpringBootApplication // This is required and tells spring to do some auto configuration for the application
public class SpringTestApplication {
    public static void main(String[] args) {
        /*
         * This starts the application!
         */
        SpringApplication.run(SpringTestApplication.class, args);
    }
}
