<<<<<<< HEAD
package com.amazon.yudoo.controller.interceptor;

import com.amazon.yudoo.exception.UnauthorizedException;
import com.amazon.yudoo.util.JwtUtil;
import com.amazon.yudoo.util.UrlMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HeaderInterceptor implements HandlerInterceptor {
    @Autowired
    JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        if (request.getRequestURI().contains(UrlMapping.SIGNIN)
                || request.getRequestURI().contains(UrlMapping.SIGNUP)) {
            System.out.println(request.getRequestURI());
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
=======
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
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hanler)throws Exception{
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
>>>>>>> 7b8e0a30cd9ed97930e2a75ee4527e74dc12572c
