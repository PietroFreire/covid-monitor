package com.covidmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/auth")
public class AuthController {

    @GetMapping("/process")
    public String process(){
        return "processando...";
    }
}
