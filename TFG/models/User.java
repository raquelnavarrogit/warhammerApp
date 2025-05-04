package TFG.TFG.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="USERS")
public class User {

    @Column(name = "USERNAME", nullable = false, unique=true)
    private String username;

    @Id
    @Column(name = "EMAIL", nullable = false, unique=true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "POINTS")
    private int points;

    @Column(name = "LEVEL")
    private String level;

    @ManyToMany
    @JoinTable(
            name = "USER_EVENT",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "EVENT_ID")
    )
    private List<Event> events;

    @ManyToMany
    @JoinTable(
            name = "USER_WORKSHOP",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKSHOP_ID")
    )
    private Set<Workshop> workshops = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Set<Workshop> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Set<Workshop> workshops) {
        this.workshops = workshops;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", points=" + points +
                ", level='" + level + '\'' +
                ", events=" + events.stream().map(Event::getName).toList() +
                ", workshops=" + workshops.stream().map(Workshop::getName).toList() +
                '}';
    }
}
