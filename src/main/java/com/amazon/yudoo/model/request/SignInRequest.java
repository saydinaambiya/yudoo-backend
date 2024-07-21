package com.amazon.yudoo.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SignInRequest {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;

    @Override
    public String toString() {
        return "SignInRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
