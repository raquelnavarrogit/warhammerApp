package com.example.demo.dtos;

import com.example.demo.models.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

    private int id;
    private String name;
    private String description;
    private LocalDateTime time;
    private LocalDate day;
    private String image;
    private int duration;
    private int place;
    private ActivityType type;

}
