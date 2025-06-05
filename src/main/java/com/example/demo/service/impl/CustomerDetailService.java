package com.example.demo.service.impl;

import com.example.demo.daos.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailService {

    @Resource
    private UserDao userDao;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserModel user = userDao.findById(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
//        return User.builder()
//                .username(user.getEmail())
//                .password(user.getPassword())
//                .build();
//    }
}
