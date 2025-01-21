package htw_berlin.movie_webtech.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String description;
        private int releaseYear;
        private String imageUrl;
        private boolean watched;

        @ElementCollection
        @CollectionTable(name = "movie_genre_ids", joinColumns = @JoinColumn(name = "movie_id"))
        @Column(name = "genre_id")
        private Set<Long> genreIds = new HashSet<>();

        // Benutzerdefinierter Konstruktor (ohne ID, für neue Einträge)
        public Movie(String title, String description, int releaseYear, String imageUrl, boolean watched, Set<Long> genreIds) {
                this.title = title;
                this.description = description;
                this.releaseYear = releaseYear;
                this.imageUrl = imageUrl;
                this.watched = watched;
                this.genreIds = genreIds;
        }
}
