package com.example.demo.dtos;

import com.example.demo.models.ActivityType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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

    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @FutureOrPresent
    private LocalDateTime time;
    @FutureOrPresent
    private LocalDate day;
    private String image;
    @Max(120)
    @Positive
    private int duration;
    @Max(15)
    @Positive
    private int place;
    @NotBlank
    private ActivityType type;

}
