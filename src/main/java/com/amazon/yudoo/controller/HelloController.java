package com.amazon.yudoo.controller;

import com.amazon.yudoo.util.UrlMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlMapping.BASE + "/")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> sayHello(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return ResponseEntity.status(HttpStatus.OK).body("Hello " + name);
    }
}
