package com.example.TATA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demo {
    @GetMapping("/mydemo")
    public String getData(){
        return "Please book your  Flimkkjlkljkjlght ticket, Choose Your Fav Airlines Idigo";
    }

}