package com.example.demo.dtos;

import com.example.demo.models.ActivityModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String email;
    private String username;
    private int points;
    private String level;
    private List<ActivityModel> activities;

}
