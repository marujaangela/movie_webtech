package htw_berlin.movie_webtech.persistence;

import htw_berlin.movie_webtech.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für Movie-Entitäten, das auf Spring Data JPA basiert.
 * Automatische Bereitstellung von CRUD-Operationen.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // JpaRepository stellt bereits alle benötigten Methoden bereit:
    // - findById
    // - save
    // - existsById
    // - deleteById
    // - findAll
}
