package com.amazon.yudoo.controller.interceptor;

import com.amazon.yudoo.exception.UnauthorizedException;
import com.amazon.yudoo.util.JwtUtil;
import com.amazon.yudoo.util.UrlMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Component
public class HeaderInterceptor implements HandlerInterceptor {
    @Autowired
    JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("uri: " + request.getRequestURI());
        if (request.getRequestURI().contains(UrlMapping.SIGNIN)
                || Objects.equals(request.getRequestURI(), UrlMapping.BASE + UrlMapping.SIGNUP)
                || Objects.equals(request.getRequestURI(), "/api/v0/")
                || Objects.equals(request.getRequestURI(), UrlMapping.OPEN_API + "/index.html")
                || Objects.equals(request.getRequestURI(), "/v3/api-docs")
        ) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new UnauthorizedException();
        }
        String[] bearerToken = token.split(" ");
        return jwtUtil.isJwtTokenValid(bearerToken[1]);
    }
}
