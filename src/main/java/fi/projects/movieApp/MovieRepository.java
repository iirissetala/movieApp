package fi.projects.movieApp;

import fi.projects.movieApp.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "Select * from movies where lower(movie_name) like %:name%", nativeQuery = true)
    List<Movie> findMoviesByNamePart(@Param("name") String name);

    @Query(value = "Select * from movies where lower(movie_name) = :name", nativeQuery = true)
    Movie findMovieByName(@Param("name") String name);

    @Query(value = "Select * from movies where year=:year", nativeQuery = true)
    List<Movie> findMoviesByYear(@Param("year") int year);

}
