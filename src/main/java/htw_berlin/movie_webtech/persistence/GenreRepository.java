package htw_berlin.movie_webtech.persistence;

import htw_berlin.movie_webtech.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {}
