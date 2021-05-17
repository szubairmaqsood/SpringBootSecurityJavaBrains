package com.example.SpringSecurityJavaBrains.Controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeResource {
    @GetMapping("/")
    fun home():String{
        return "Welcome Home"
    }
}