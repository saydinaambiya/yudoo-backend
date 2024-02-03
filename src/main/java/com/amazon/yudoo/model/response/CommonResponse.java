package com.amazon.yudoo.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CommonResponse {
    private String code;
    private boolean status;
    private String message;
}
