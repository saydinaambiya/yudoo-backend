//package com.amazon.yudoo.controller.interceptor;
//
//import com.amazon.yudoo.exception.UnauthorizedException;
//import com.amazon.yudoo.util.JwtUtil;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class HeaderInterceptor implements HandlerInterceptor {
//    JwtUtil jwtUtil;
//
//    public HeaderInterceptor(JwtUtil jwtUtil){
//        this.jwtUtil = jwtUtil;
//    }
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
//        if (request.getRequestURI().contains("/login")) {
//            return true;
//        }
//    String token = request.getHeader("Authorization");
//        if (token == null) throw new UnauthorizedException();
//        String[] bearerToken = token.split(" ");
//        return jwtUtil.isJwtTokenValid(bearerToken[1]);
//    }
//
//
//}
