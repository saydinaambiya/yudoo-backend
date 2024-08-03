package com.amazon.yudoo.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TagsRequest {
    @NotEmpty
    private String tagName;
}
