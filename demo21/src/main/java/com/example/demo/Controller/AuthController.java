package com.example.demo.Controller;

import com.example.demo.Entity.User;

import com.example.demo.Service.UserService;
import com.example.demo.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.demo.Common.ApiResponse;
import com.example.demo.Common.StatusCode;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ApiResponse<?> register(@RequestBody User user) {
        try {
            User registeredUser = userService.register(user.getUsername(), user.getPassword());
            return ApiResponse.success(registeredUser);
        } catch (Exception e) {
            return ApiResponse.error(StatusCode.SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody User user) {
        try {
            // 首先检查用户是否存在
            User existingUser = userService.findByUsername(user.getUsername());
            if (existingUser == null) {
                return ApiResponse.error(StatusCode.VALIDATION_ERROR.getCode(), "User not found");
            }

            // 尝试进行认证
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenUtil.generateToken(user.getUsername());
            return ApiResponse.success(new JwtResponse(token, user.getUsername()));
        } catch (Exception e) {
            if (e.getMessage().contains("Bad credentials")) {
                return ApiResponse.error(StatusCode.VALIDATION_ERROR.getCode(), "Invalid username or password");
            }
            return ApiResponse.error(StatusCode.SERVER_ERROR.getCode(), "Authentication failed: " + e.getMessage());
        }
    }

    private class JwtResponse {
        private String token;
        private String username;

        public JwtResponse(String token, String username) {
            this.token = token;
            this.username = username;
        }

        public String getToken() {
            return token;
        }

        public String getUsername() {
            return username;
        }
    }
}