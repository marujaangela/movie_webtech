package htw_berlin.test.java.htw_berlin.movie_webtech.service;

import htw_berlin.movie_webtech.model.Genre;
import htw_berlin.movie_webtech.persistence.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Testklasse für GenreService.
 * Testet die grundlegenden CRUD-Operationen des Services.
 */
public class GenreServiceTest {

//    private GenreRepository genreRepository;
//    private GenreService genreService;
//
//    /**
//     * Setup-Methode, die vor jedem Test aufgerufen wird.
//     * Initialisiert den GenreService mit einem Mock-Repository.
//     */
//    @BeforeEach
//    void setup() {
//        genreRepository = Mockito.mock(GenreRepository.class);
//        genreService = new GenreService(genreRepository);
//    }
//
//    /**
//     * Test für das Abrufen aller Genres.
//     * Stellt sicher, dass die Methode `getGenres` korrekt arbeitet.
//     */
//    @Test
//    void testGetGenres() {
//        // Arrange
//        List<Genre> mockGenres = Arrays.asList(
//                new Genre(1L, "Action"),
//                new Genre(2L, "Drama")
//        );
//        when(genreRepository.findAll()).thenReturn(mockGenres);
//
//        // Act
//        List<Genre> result = (List<Genre>) genreService.getGenres();
//
//        // Assert
//        assertEquals(mockGenres, result);
//        verify(genreRepository, times(1)).findAll();
//    }
//
//    /**
//     * Test für das Abrufen eines Genres anhand der ID.
//     * Stellt sicher, dass die Methode `getGenre` korrekt arbeitet.
//     */
//    @Test
//    void testGetGenreById() {
//        // Arrange
//        Genre mockGenre = new Genre(1L, "Action");
//        when(genreRepository.findById(1L)).thenReturn(Optional.of(mockGenre));
//
//        // Act
//        Optional<Genre> result = genreService.getGenre(1L);
//
//        // Assert
//        assertTrue(result.isPresent());
//        assertEquals(mockGenre, result.get());
//        verify(genreRepository, times(1)).findById(1L);
//    }
//
//    /**
//     * Test für das Hinzufügen eines neuen Genres.
//     * Stellt sicher, dass die Methode `addGenre` korrekt arbeitet.
//     */
//    @Test
//    void testAddGenre() {
//        // Arrange
//        Genre newGenre = new Genre(null, "Comedy");
//        Genre savedGenre = new Genre(1L, "Comedy");
//        when(genreRepository.save(newGenre)).thenReturn(savedGenre);
//
//        // Act
//        Genre result = genreService.addGenre(newGenre);
//
//        // Assert
//        assertEquals(savedGenre, result);
//        verify(genreRepository, times(1)).save(newGenre);
//    }
//
//    /**
//     * Test für das Entfernen eines Genres anhand der ID.
//     * Stellt sicher, dass die Methode `removeGenre` korrekt arbeitet.
//     */
//    @Test
//    void testRemoveGenre() {
//        // Arrange
//        when(genreRepository.existsById(1L)).thenReturn(true);
//
//        // Act
//        boolean result = genreService.removeGenre(1L);
//
//        // Assert
//        assertTrue(result);
//        verify(genreRepository, times(1)).existsById(1L);
//        verify(genreRepository, times(1)).deleteById(1L);
//    }
}
