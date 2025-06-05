package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "activity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "users")
/*@Cacheable //es para indicar que es almacenable en la cache. Se usa con cosas que no se modifican habitualmente, puede mejorar el rendimiento pero solo si se usa bien.
//@Cache(usage= CacheConcurrencyStrategy., region = , expiry = ) aquí indicamos cómo usar la cache.*/
public class ActivityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "day")
    private LocalDate day;

    @Column(name = "image")
    private String image;

    @Column(name = "duration")
    private int duration;

    @Column(name = "places")
    private int place;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @ManyToMany(mappedBy = "activities",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<UserModel> users = new ArrayList<>();

    public ActivityModel(Long id, String name, String description, LocalDateTime time, LocalDate day, String image, int duration, int place, ActivityType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.day = day;
        this.image = image;
        this.duration = duration;
        this.place = place;
        this.type = type;
    }
}


