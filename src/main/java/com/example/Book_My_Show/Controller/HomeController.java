package com.example.Book_My_Show.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    public String index(){
        return "Greetings";
    }

    @GetMapping
    public String index1(){
        return "Greetings from Spring Boot!";
    }
}
