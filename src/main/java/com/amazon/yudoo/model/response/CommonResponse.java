package com.amazon.yudoo.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CommonResponse {
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime timestamp = LocalDateTime.now();
    private String code;
    private String status;
    private String message;
}
