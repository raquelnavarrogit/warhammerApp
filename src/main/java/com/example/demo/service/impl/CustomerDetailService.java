package com.example.demo.service.impl;

import com.example.demo.daos.UserDao;
import com.example.demo.models.UserModel;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailService implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userDao.findById(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
