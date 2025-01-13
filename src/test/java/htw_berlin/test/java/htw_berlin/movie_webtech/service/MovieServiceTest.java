package htw_berlin.test.java.htw_berlin.movie_webtech.service;

import htw_berlin.movie_webtech.model.Movie;
import htw_berlin.movie_webtech.persistence.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Testklasse für MovieService.
 * Testet die grundlegenden Funktionen des MovieService.
 */
//@SpringBootTest
public class MovieServiceTest {
//
//    @Autowired
//    private MovieService service;
//
//    @MockBean
//    private MovieRepository repository;
//
//    /**
//     * Initialisiert Mock-Daten im Repository vor jedem Test.
//     */
//    @BeforeEach
//    void setUpMockRepository() {
//        final Movie inception = new Movie(1L, "Inception", 2010, "A mind-bending thriller", "Sci-Fi", "image1.jpg");
//        final Movie matrix = new Movie(2L, "The Matrix", 1999, "A computer hacker learns about reality", "Action", "image2.jpg");
//
//        doReturn(List.of(inception, matrix)).when(repository).findAll();
//        doReturn(Optional.of(inception)).when(repository).findById(1L);
//        doReturn(true).when(repository).existsById(1L);
//    }
//
//    /**
//     * Testet die Methode getMovies().
//     */
//    @Test
//    void testGetMovies() {
//        Iterable<Movie> resultAsIterable = service.getMovies();
//        List<Movie> result = StreamSupport.stream(resultAsIterable.spliterator(), false).toList();
//
//        assertEquals(2, result.size(), "Es sollten zwei Filme abgerufen werden.");
//        verify(repository, times(1)).findAll();
//    }
//
//    /**
//     * Testet die Methode getMovie(Long id).
//     */
//    @Test
//    void testGetMovieById() {
//        Optional<Movie> result = service.getMovie(1L);
//
//        assertTrue(result.isPresent(), "Movie mit ID 1 sollte vorhanden sein.");
//        assertEquals("Inception", result.get().getTitle(), "Der Titel des Movies sollte 'Inception' sein.");
//        verify(repository, times(1)).findById(1L);
//    }
//
//    /**
//     * Testet die Methode addMovie(Movie movie).
//     */
//    @Test
//    void testAddMovie() {
//        Movie newMovie = new Movie(null, "Interstellar", 2014, "A journey through space and time", "Sci-Fi", "image3.jpg");
//        Movie savedMovie = new Movie(3L, "Interstellar", 2014, "A journey through space and time", "Sci-Fi", "image3.jpg");
//
//        doReturn(savedMovie).when(repository).save(newMovie);
//
//        Movie result = service.addMovie(newMovie);
//
//        assertEquals(savedMovie, result, "Das gespeicherte Movie sollte dem erwarteten Movie entsprechen.");
//        verify(repository, times(1)).save(newMovie);
//    }
//
//    /**
//     * Testet die Methode editMovie(Movie movie).
//     */
//    @Test
//    void testEditMovie() {
//        Movie updatedMovie = new Movie(1L, "Inception 2", 2020, "A sequel to Inception", "Sci-Fi", "image1_updated.jpg");
//
//        doReturn(updatedMovie).when(repository).save(updatedMovie);
//
//        Movie result = service.editMovie(updatedMovie);
//
//        assertEquals(updatedMovie, result, "Das aktualisierte Movie sollte dem erwarteten Movie entsprechen.");
//        verify(repository, times(1)).save(updatedMovie);
//    }
//
//    /**
//     * Testet die Methode removeMovie(Long id).
//     */
//    @Test
//    void testRemoveMovie() {
//        boolean result = service.removeMovie(1L);
//
//        assertTrue(result, "Movie mit ID 1 sollte erfolgreich entfernt werden.");
//        verify(repository, times(1)).existsById(1L);
//        verify(repository, times(1)).deleteById(1L);
//    }
//
//    /**
//     * Testet die Methode getMoviesByTitle(String title).
//     */
//    @Test
//    void testGetMoviesByTitle() {
//        Iterable<Movie> resultAsIterable = service.getMovies("Inception");
//        List<Movie> result = StreamSupport.stream(resultAsIterable.spliterator(), false).toList();
//
//        assertEquals(1, result.size(), "Es sollte genau ein Film mit dem Titel 'Inception' abgerufen werden.");
//        assertEquals("Inception", result.get(0).getTitle(), "Der Titel sollte 'Inception' sein.");
//    }
//
//    /**
//     * Testet die Methode getMoviesByYear(int releaseYear).
//     */
//    @Test
//    void testGetMoviesByYear() {
//        Iterable<Movie> resultAsIterable = service.getMoviesByYear(2010);
//        List<Movie> result = StreamSupport.stream(resultAsIterable.spliterator(), false).toList();
//
//        assertEquals(1, result.size(), "Es sollte genau ein Film mit dem Veröffentlichungsjahr 2010 abgerufen werden.");
//        assertEquals("Inception", result.get(0).getTitle(), "Der Titel des Films sollte 'Inception' sein.");
//    }
}
