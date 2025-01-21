package htw_berlin.movie_webtech.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Numerische ID
    private String name; // Name des Genres

    // Konstruktor für neue Genre-Einträge
    public Genre(String name) {
        this.name = name;
    }
}
