package com.amazon.yudoo.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotBlank(message = "Category Name is Required")
    private String categoryName;
}
