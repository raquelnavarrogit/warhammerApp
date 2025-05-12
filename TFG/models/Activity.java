package TFG.TFG.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
/*@Cacheable //es para indicar que es almacenable en la cache. Se usa con cosas que no se modifican habitualmente, puede mejorar el rendimiento pero solo si se usa bien.
//@Cache(usage= CacheConcurrencyStrategy., region = , expiry = ) aquí indicamos cómo usar la cache.*/
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

}

enum ActivityType {
    WORKSHOP, EVENT
}


