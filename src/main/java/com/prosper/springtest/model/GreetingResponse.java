package com.prosper.springtest.model;

import java.io.Serializable;

/**
 * Created by gpanneerselvam on 4/18/17.
 */
public class GreetingResponse implements Serializable {

    private final String greeting;

    public GreetingResponse() {
        this.greeting = "Hello there, Stranger!!";
    }

    public GreetingResponse(String name) {
        this.greeting = "Hello there, " + name;
    }

    public GreetingResponse(String name, String greeting) {
        this.greeting = greeting + name;
    }

    public String getGreeting() {
        return greeting;
    }

}
