package com.amazon.yudoo.controller;

import com.amazon.yudoo.model.Tags;
import com.amazon.yudoo.model.request.TagsRequest;
import com.amazon.yudoo.model.response.SuccessResponse;
import com.amazon.yudoo.service.TagsService;
import com.amazon.yudoo.util.JwtUtil;
import com.amazon.yudoo.util.UrlMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlMapping.BASE + UrlMapping.TAGS)
public class TagsController {
    private static final Logger log = LoggerFactory.getLogger(TagsController.class);
    private final TagsService tagsService;
    private final HttpServletRequest request;
    private final JwtUtil jwtUtil;

    public TagsController(TagsService tagsService, HttpServletRequest request, JwtUtil jwtUtil) {
        this.tagsService = tagsService;
        this.request = request;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping()
    ResponseEntity<?> createTag(@Valid @RequestBody TagsRequest tagsRequest) {
        String token = request.getHeader("Authorization");
        String[] bearerToken = token.split(" ");
        String email = jwtUtil.getTokenSubject(bearerToken[1]);
        Tags newTags = tagsService.create(tagsRequest, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Tag created", newTags));
    }
}
