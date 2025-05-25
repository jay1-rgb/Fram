package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password);
    User findByUsername(String username);
}
