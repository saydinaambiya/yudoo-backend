package com.amazon.yudoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // Add comment to push development branch
    @GetMapping
    public ResponseEntity<String> sayHello(@RequestParam(name = "name", required = false, defaultValue = "World") String name){
        return ResponseEntity.status(HttpStatus.OK).body("Hello " + name);
    }
}
