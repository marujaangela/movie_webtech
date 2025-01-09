package htw_berlin.movie_webtech.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "genres") // Vermeidet potenzielle Endlosschleifen in bidirektionalen Beziehungen
public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String description;
        private int releaseYear;
        private String imageUrl;
        private boolean watched;

        @ManyToMany(cascade = CascadeType.PERSIST) // Performance-Optimierung durch LAZY Loading
        @JoinTable(
                name = "movie_genre",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "genre_id")
        )
        private Set<Genre> genres;

        // Benutzerdefinierter Konstruktor (ohne ID, für neue Einträge)
        public Movie(String title, String description, int releaseYear, String imageUrl, boolean watched, Set<Genre> genres) {
                this.title = title;
                this.description = description;
                this.releaseYear = releaseYear;
                this.imageUrl = imageUrl;
                this.watched = watched;
                this.genres = genres;
        }
}
