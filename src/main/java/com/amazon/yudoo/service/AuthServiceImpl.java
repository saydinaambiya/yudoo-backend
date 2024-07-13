package com.amazon.yudoo.service;

import com.amazon.yudoo.exception.NotFoundException;
import com.amazon.yudoo.exception.UnauthorizedException;
import com.amazon.yudoo.model.Role;
import com.amazon.yudoo.model.User;
import com.amazon.yudoo.model.UserCredential;
import com.amazon.yudoo.model.request.SignInRequest;
import com.amazon.yudoo.model.request.SignUpRequest;
import com.amazon.yudoo.repository.AuthRepository;
import com.amazon.yudoo.util.JwtUtil;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    AuthRepository authRepository;
    UserService userService;


    @Autowired
    JwtUtil jwtUtil;

    public AuthServiceImpl(AuthRepository authRepository, UserService userService) {
        this.authRepository = authRepository;
        this.userService = userService;
    }

    @Transactional
    @Override
    public String signUp(SignUpRequest signUpRequest) {
        try {
            UserCredential userCredential = new UserCredential();
            userCredential.setEmail(signUpRequest.getEmail());
            userCredential.setPassword(signUpRequest.getPassword());
            userCredential.setRole(Role.BASIC);
            userCredential.setActive(true);
            UserCredential authResult = authRepository.save(userCredential);

            User user = new User();
            user.setUserCredential(authResult);
            userService.updateById(user);

            return jwtUtil.generateToken(user.getUserCredential().getEmail());
        }catch (DataIntegrityViolationException e){
          throw new EntityExistsException();
        }
    }

    @Transactional
    @Override
    public String signIn(SignInRequest signInRequest) {
        try {
            Optional<UserCredential> userCredential = authRepository.findById(signInRequest.getEmail());
            if (userCredential.isEmpty()) throw new NotFoundException();
            if (!userCredential.get().getPassword().equals(signInRequest.getPassword())) {
                throw new UnauthorizedException("Email and Password not matched");
            }

            return jwtUtil.generateToken(signInRequest.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
