package com.amazon.yudoo.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TagsRequest {
    @NotBlank(message = "Tags name cannot be blank")
    private String tagName;
}
