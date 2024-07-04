package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SampleController {
    @GetMapping("/commentry")
    public String getUser(){
        return "Never ever bet against MSD and his men";
    }
    @GetMapping("/sayComeback/{name}")
    public String sayComeback(@PathVariable("name") String name){
        return  name + " thirumbi vanthutom sollu," ;
    }
}
