package com.amazon.yudoo.service;

import com.amazon.yudoo.model.request.SignInRequest;
import com.amazon.yudoo.model.request.SignUpRequest;

public interface AuthService {
    String signUp(SignUpRequest signUpRequest);
    String signIn(SignInRequest signInRequest);
}
