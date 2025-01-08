package htw_berlin.movie_webtech.web;

import htw_berlin.movie_webtech.model.Movie;
import htw_berlin.movie_webtech.service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    // Alle Filme abrufen oder nach Titel filtern
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Movie>> getMovies(@RequestParam final Optional<String> title) {
        final Iterable<Movie> result = title.isEmpty() || title.get().isBlank()
                ? movieService.getMovies()
                : movieService.getMovies(title.get());
        return ResponseEntity.ok(result);
    }

    // Ein bestimmtes Movie abrufen
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") final Long id) {
        final Optional<Movie> movieOptional = movieService.getMovie(id);
        if (!movieOptional.isPresent()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(movieOptional.get());
    }

    // Einen neuen Film hinzufügen
    @PostMapping
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody final Movie movie) {
        final Movie created = movieService.addMovie(movie);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Einen bestehenden Film aktualisieren
    @PutMapping(path = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") final Long id, @RequestBody Movie body) {
        body.setId(id); // ID aus der URL in das Body-Objekt übernehmen
        final Movie updatedMovie = movieService.editMovie(body);
        return updatedMovie == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedMovie);
    }

    // Einen Film löschen
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") final Long id) {
        return movieService.removeMovie(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Filme nach Genre filtern
    @GetMapping("/genre")
    public ResponseEntity<Iterable<Movie>> getMoviesByGenre(@RequestParam String genre) {
        final Iterable<Movie> result = movieService.getMoviesByGenre(genre);
        return ResponseEntity.ok(result);
    }

    // Filme nach Jahr filtern
    @GetMapping("/year")
    public ResponseEntity<Iterable<Movie>> getMoviesByYear(@RequestParam int year) {
        final Iterable<Movie> result = movieService.getMoviesByYear(year);
        return ResponseEntity.ok(result);
    }
}

