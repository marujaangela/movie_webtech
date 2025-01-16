package htw_berlin.movie_webtech.service;

import htw_berlin.movie_webtech.model.Genre;
import htw_berlin.movie_webtech.persistence.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    // Alle Genres abrufen
    public Iterable<Genre> getGenres() {
        return repository.findAll();
    }

    // Ein bestimmtes Genre abrufen
    public Optional<Genre> getGenre(long id) {
        return repository.findById(id);
    }

    // Ein neues Genre hinzufügen
    public Genre addGenre(Genre genre) {
        return repository.save(genre);
    }

    // Ein Genre bearbeiten
    public Genre editGenre(Genre genre) {
        if (!repository.existsById(genre.getId())) return null;
        return repository.save(genre);
    }

    // Ein Genre löschen
    public boolean removeGenre(long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    // Genres nach Namen filtern (optional)
    public Iterable<Genre> getGenresByName(String name) {
        return StreamSupport.stream(getGenres().spliterator(), false)
                .filter(genre -> genre.getName().equalsIgnoreCase(name))
                .collect(Collectors.toSet());
    }
}
