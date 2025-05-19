package com.example.demo.daos;

import com.example.demo.models.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityDao extends JpaRepository<ActivityModel, Long> {
    Optional<ActivityModel> getActivityModelById(int id);
}
