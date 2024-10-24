package htw_berlin.movie_webtech;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
        private String name;
        private int year;
        private String kategorie;
        private String describtion;
        private String pictureLink;

}
