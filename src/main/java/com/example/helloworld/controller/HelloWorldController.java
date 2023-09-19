package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;


@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String getStudents()
    {

        //final String uri = "https://producer-git-testapp.apps-crc.testing/hello";
        final String uri = "http://10.217.4.168:8080/hello";

        String result = "stringa vuota";
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
            return "str: " + result;
        }
        catch (Exception e){
            // Ritorna il risultato che stamperebbe e.printStackTrace()
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            return "str EXCEPTION: " + errors.toString();
        }

    }
    @GetMapping("/test")
    public String sendGreetings() {
        return "Il consumer funziona";
    }
}
