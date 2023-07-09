package com.anyaudit.service;

import com.anyaudit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AuthManager {
    @Autowired
    private UserRepository userRepository;


    public List<Object[]> findNameAndId() {
        return userRepository.findNameAndId();
    }
}
