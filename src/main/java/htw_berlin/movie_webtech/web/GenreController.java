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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Genre>> getGenres() {
        return ResponseEntity.ok(genreService.getGenres());
    }

    // Ein bestimmtes Genre abrufen
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable("id") final Long id) {
        final Optional<Genre> genreOptional = genreService.getGenre(id);
        if (!genreOptional.isPresent()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(genreOptional.get());
    }

    // Ein neues Genre hinzufügen
    @PostMapping
    public ResponseEntity<Genre> addGenre(@Valid @RequestBody final Genre genre) {
        final Genre created = genreService.addGenre(genre);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Ein Genre aktualisieren
    @PutMapping(path = "/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable("id") final Long id, @RequestBody Genre body) {
        body.setId(id); // ID aus der URL in das Body-Objekt übernehmen
        final Genre updatedGenre = genreService.editGenre(body);
        return updatedGenre == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedGenre);
    }

    // Ein Genre löschen
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable("id") final Long id) {
        return genreService.removeGenre(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
