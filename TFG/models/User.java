package TFG.TFG.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "username", nullable = false, unique=true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "points")
    private int points;

    @Column(name = "level")
    private String level;

}
