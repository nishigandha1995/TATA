package com.example.TATA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hotel {
    @GetMapping("/myhotel")
    public String getData(){
        return "Please sss book sss your  hotel ticket, Choose Your Fav Airlines Idigo";
    }

}
