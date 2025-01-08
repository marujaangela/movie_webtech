package htw_berlin.movie_webtech.web;

import htw_berlin.movie_webtech.service.MovieService;
import htw_berlin.movie_webtech.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SsrController {

    private final MovieService movieService;
    private final GenreService genreService;

    public SsrController(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    // Startseite mit einer Liste aller Filme
    @GetMapping(path = "/")
    public ModelAndView showHomePage(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        model.addAttribute("someData", "Welcome to the Movie Web App!");
        return new ModelAndView("home");
    }

    // Seite, die Details zu einem bestimmten Movie anzeigt
    @GetMapping(path = "/movies/{id}")
    public ModelAndView showMovieDetails(@PathVariable Long id, Model model) {
        movieService.getMovie(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return new ModelAndView("movie_details");
    }

    // Seite mit einer Liste aller Genres
    @GetMapping(path = "/genres")
    public ModelAndView showGenresPage(Model model) {
        model.addAttribute("genres", genreService.getGenres());
        return new ModelAndView("genres");
    }

    // Seite mit einer Liste von Filmen nach Genre
    @GetMapping(path = "/genres/{name}/movies")
    public ModelAndView showMoviesByGenre(@PathVariable String name, Model model) {
        model.addAttribute("movies", movieService.getMoviesByGenre(name));
        model.addAttribute("genreName", name);
        return new ModelAndView("movies_by_genre");
    }
}

