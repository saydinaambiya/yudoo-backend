package com.amazon.yudoo.model.response;

import org.springframework.http.HttpStatus;

public class SuccessResponse<T> extends CommonResponse {
    T data;

    public SuccessResponse(T data, String message) {
        super.setCode("200");
        super.setMessage(message);
        super.setCode(HttpStatus.OK.name());
        this.data = data;
    }
}
