package com.amazon.yudoo.controller;

import com.amazon.yudoo.exception.UnauthorizedException;
import com.amazon.yudoo.model.request.SignInRequest;
import com.amazon.yudoo.model.request.SignUpRequest;
import com.amazon.yudoo.model.response.ErrorResponse;
import com.amazon.yudoo.model.response.SuccessResponse;
import com.amazon.yudoo.model.response.TokenResponse;
import com.amazon.yudoo.service.AuthService;
import com.amazon.yudoo.util.UrlMapping;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping(UrlMapping.BASE)
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping(UrlMapping.SIGNUP)
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        try {
            String token = authService.signUp(signUpRequest);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Sign Up", new TokenResponse(token)));
        } catch (EntityExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("400", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("500", e.getMessage()));
        }
    }

    @PostMapping(UrlMapping.SIGNIN)
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
        try {
            String token = authService.signIn(signInRequest);
            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Sign In", new TokenResponse(token)));
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("400", e.getMessage()));
        } catch (ResourceAccessException e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new ErrorResponse("408", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("500", e.getMessage()));
        }
    }
}
