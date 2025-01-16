package htw_berlin.movie_webtech.web;

import htw_berlin.movie_webtech.model.Genre;
import htw_berlin.movie_webtech.service.GenreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    // Alle Genres abrufen
    @GetMapping
    public ResponseEntity<Iterable<Genre>> getGenres() {
        return ResponseEntity.ok(genreService.getGenres());
    }

    // Ein Genre anhand der ID abrufen
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long id) {
        return genreService.getGenre(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ein neues Genre erstellen
    @PostMapping
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre) {
        return new ResponseEntity<>(genreService.addGenre(genre), HttpStatus.CREATED);
    }

    // Ein Genre bearbeiten
    @PutMapping("/{id}")
    public ResponseEntity<Genre> editGenre(@PathVariable Long id, @RequestBody Genre body) {
        body.setId(id); // ID aus der URL übernehmen
        Genre updatedGenre = genreService.editGenre(body);
        return updatedGenre != null ? ResponseEntity.ok(updatedGenre) : ResponseEntity.notFound().build();
    }

    // Ein Genre löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeGenre(@PathVariable Long id) {
        return genreService.removeGenre(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
