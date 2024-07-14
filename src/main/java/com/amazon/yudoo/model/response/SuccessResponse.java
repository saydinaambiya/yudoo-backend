package com.amazon.yudoo.model.response;

import org.springframework.http.HttpStatus;

public class SuccessResponse<T> extends CommonResponse {
    T data;

    public SuccessResponse(String message, T data) {
        super.setCode("200");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
    }
}
