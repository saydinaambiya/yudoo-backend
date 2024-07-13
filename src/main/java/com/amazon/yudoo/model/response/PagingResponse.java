package com.amazon.yudoo.model.response;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class PagingResponse<T> extends CommonResponse {
    private List<T> data;
    private long count;
    private int totalPage;
    private int page;
    private int pageSize;

    public PagingResponse(String message, Page<T> page) {
        super.setCode("200");
        super.setStatus(message);
        super.setMessage(HttpStatus.OK.name());
        this.data = page.getContent();
        this.count = page.getTotalElements();
        this.totalPage = page.getTotalPages();
        this.page = page.getNumber() + 1;
        this.pageSize = page.getSize();
    }
}
