package com.joshuamatos.Crud2.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
}