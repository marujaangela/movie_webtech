package htw_berlin.movie_webtech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title; // Titel des Films

        @Column(length = 1000)
        private String description; // Beschreibung des Films

        private int releaseYear; // Veröffentlichungsjahr des Films

        private String imageUrl; // URL des Film-Bildes

        private boolean watched; // Gibt an, ob der Film gesehen wurde

        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(
                name = "movie_genre",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "genre_id")
        )
        private Set<Genre> genres; // Beziehung zu Genres

        public Movie(Long id, String title, int releaseYear, String description, String imageUrl, String genre) {
                this.id = id;
                this.title = title;
                this.releaseYear = releaseYear;
                this.description = description;
                this.imageUrl = imageUrl;
        }
}
