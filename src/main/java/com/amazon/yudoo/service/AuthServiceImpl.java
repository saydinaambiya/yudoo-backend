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
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
    AuthRepository authRepository;
    UserService userService;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    ModelMapper modelMapper;

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
            userCredential.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            userCredential.setRole(Role.BASIC);
            userCredential.setActive(true);
            UserCredential savedUserCredential = authRepository.save(userCredential);


            User user = new User();
            user.setName(signUpRequest.getName());
            user.setUserCredential(savedUserCredential);
            user.setProfilePictureUrl(signUpRequest.getProfilePictureUrl());
            String token = jwtUtil.generateToken(user.getUserCredential().getEmail());
            user.setRememberToken(token);
            userService.create(user);
            return token;
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistsException();
        }
    }

    @Transactional
    @Override
    public String signIn(SignInRequest signInRequest) {
        Optional<UserCredential> userCredential = authRepository.findById(signInRequest.getEmail());
        if (userCredential.isEmpty()) throw new NotFoundException();
        String rawPassword = signInRequest.getPassword();
        String encodedPassword = userCredential.get().getPassword();
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new UnauthorizedException("Email and Password not matched");
        }

        return jwtUtil.generateToken(signInRequest.getEmail());

    }
}
