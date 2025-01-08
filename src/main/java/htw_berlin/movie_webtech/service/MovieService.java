package htw_berlin.movie_webtech.service;

import htw_berlin.movie_webtech.model.Movie;
import htw_berlin.movie_webtech.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public MovieService(MovieRepository movieRepository) {
    }

    // Alle Filme abrufen
    public Iterable<Movie> getMovies() {
        return this.repository.findAll();
    }

    // Filme nach Titel suchen
    public Iterable<Movie> getMovies(final String title) {
        return StreamSupport.stream(this.getMovies().spliterator(), false)
                .filter(movie -> movie.getTitle() != null && movie.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toSet());
    }

    // Ein bestimmtes Movie abrufen
    public Optional<Movie> getMovie(final Long id) {
        return this.repository.findById(id);
    }

    // Einen neuen Film hinzufügen
    public Movie addMovie(final Movie movie) {
        return this.repository.save(movie);
    }

    // Einen Film bearbeiten
    public Movie editMovie(final Movie movie) {
        if (!this.repository.existsById(movie.getId())) return null;

        return addMovie(movie);
    }

    // Einen Film löschen
    public boolean removeMovie(final Long id) {
        final boolean exists = this.repository.existsById(id);
        if (exists) this.repository.deleteById(id);
        return exists;
    }

    // Filme nach Genre filtern
    public Iterable<Movie> getMoviesByGenre(final String genreName) {
        return StreamSupport.stream(this.getMovies().spliterator(), false)
                .filter(movie -> movie.getGenres() != null &&
                        movie.getGenres().stream()
                                .anyMatch(genre -> genre.getName().equalsIgnoreCase(genreName)))
                .collect(Collectors.toSet());
    }

    // Filme nach Jahr filtern
    public Iterable<Movie> getMoviesByYear(final int releaseYear) {
        return StreamSupport.stream(this.getMovies().spliterator(), false)
                .filter(movie -> movie.getReleaseYear() == releaseYear)
                .collect(Collectors.toSet());
    }
}
