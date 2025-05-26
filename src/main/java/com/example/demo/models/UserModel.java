package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class UserModel {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "points")
    private int points;

    @Column(name = "level")
    private String level;

    @ManyToMany
    @JoinTable(
            name = "users_activities",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_id")}
    )
    @Builder.Default
    private List<ActivityModel> activities = new ArrayList<>();

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Boolean enabled;

    public UserModel(String email, String username, String level, int points, List<ActivityModel> activities) {
        this.email = email;
        this.username = username;
        this.level = level;
        this.points = points;
        this.activities = activities;
    }

    public UserModel(@Email @NotBlank String email, @NotBlank String username, @NotBlank String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
