package com.example.demo.daos;

import com.example.demo.models.ActivityModel;
import com.example.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<UserModel, String> {
    List<UserModel> findByActivities(List<ActivityModel> activities);
}
