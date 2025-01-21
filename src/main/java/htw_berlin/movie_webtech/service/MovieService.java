package htw_berlin.movie_webtech.service;

import htw_berlin.movie_webtech.model.Movie;
import htw_berlin.movie_webtech.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    // Alle Filme abrufen
    public Iterable<Movie> getMovies() {
        return repository.findAll();
    }

    // Filme nach Titel suchen
    public Iterable<Movie> getMovies(final String title) {
        return repository.findAll().stream()
                .filter(movie -> movie.getTitle() != null && movie.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toSet());
    }

    // Ein bestimmtes Movie abrufen
    public Optional<Movie> getMovie(final Long id) {
        return repository.findById(id);
    }

    // Einen neuen Film hinzufügen
    public Movie addMovie(final Movie movie) {
        return repository.save(movie);
    }

    // Einen Film bearbeiten
    public Movie editMovie(final Movie movie) {
        if (!repository.existsById(movie.getId())) return null;

        return repository.save(movie);
    }

    // Einen Film löschen
    public boolean removeMovie(final Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    // Filme nach Genre-ID filtern
    public Iterable<Movie> getMoviesByGenreId(final Long genreId) {
        return repository.findAllByGenreIdsContaining(genreId);
    }

    // Filme nach Jahr filtern
    public Iterable<Movie> getMoviesByYear(final int releaseYear) {
        return repository.findAll().stream()
                .filter(movie -> movie.getReleaseYear() == releaseYear)
                .collect(Collectors.toSet());
    }
}
