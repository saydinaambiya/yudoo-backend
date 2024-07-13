package com.amazon.yudoo.model.response;

import lombok.Data;

@Data
public class CommonResponse {
    private String code;
    private String status;
    private String message;
}
