package com.example.demo.daos;

import com.example.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserModel, String> {
}
