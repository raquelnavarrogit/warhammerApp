package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString(exclude = "password")
public class UserModel {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "points")
    private int points = 0;

    @Column(name = "level")
    private String level = "Servidor";

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.valueOf("LOGGED_USER");

    @ManyToMany
    @JoinTable(
            name = "users_activities",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_id")}
    )
    private List<ActivityModel> activities = new ArrayList<>();

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
