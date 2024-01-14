package com.amazon.yudoo.model.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "SignInRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
