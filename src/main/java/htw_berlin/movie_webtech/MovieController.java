package htw_berlin.movie_webtech;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
    @GetMapping(path = "/movies")
    public ResponseEntity<Movie[]> getMovies() {
        final Movie movie1 = new Movie("Scary Movie", 2000, "Comedy/Horror",
                "In der Horror-Parodie Scary Movie nehmen Anna Farris und ihre Freunde die erfolgreichsten Horror-Filme der letzten Jahre aufs Korn.",
                "https://m.media-amazon.com/images/S/pv-target-images/e900fe5f2785b76c68d73b55e5a13812b85802fab074972bf96990c38077f106.jpg");

        final Movie movie2 = new Movie("The Matrix", 1999, "Action/Sci-Fi",
                "Ein Hacker entdeckt, dass die Welt, in der er lebt, nur eine Simulation ist.",
                "https://m.media-amazon.com/images/I/51EG732BV3L.jpg");

        Movie[] movies = { movie1, movie2 };
        return ResponseEntity.ok(movies);
    }
}
