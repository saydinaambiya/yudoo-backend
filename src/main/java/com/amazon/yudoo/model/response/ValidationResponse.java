package com.amazon.yudoo.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationResponse<T> extends CommonResponse {
    T errors;

    public ValidationResponse(T errors) {
        super.setCode("400");
        super.setStatus("ERROR");
        super.setMessage("Validation Failed");
        this.errors = errors;
    }
}
