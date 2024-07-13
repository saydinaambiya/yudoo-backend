package com.amazon.yudoo.controller;

import com.amazon.yudoo.model.request.SignInRequest;
import com.amazon.yudoo.model.request.SignUpRequest;
import com.amazon.yudoo.model.response.SuccessResponse;
import com.amazon.yudoo.service.AuthService;
import com.amazon.yudoo.util.UrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlMapping.BASE + UrlMapping.AUTH)
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping(UrlMapping.SIGNUP)
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest) {
        String token = authService.signUp(signUpRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Sign Up", token));
    }

    @PostMapping(UrlMapping.SIGNIN)
    public ResponseEntity signIn(@RequestBody SignInRequest signInRequest) {
        String token = authService.signIn(signInRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Sign In", token));
    }
}
