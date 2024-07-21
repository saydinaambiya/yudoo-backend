package com.amazon.yudoo.model.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, max = 50)
    private String password;
    private String profilePictureUrl;
    private boolean isActive;

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
