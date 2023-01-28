package fi.projects.movieApp.services;

import fi.projects.movieApp.models.Movie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IMovieService {
    List<Movie> getMovies();
    List<Movie> getMoviesByName(String name);
    List<Movie> getMoviesByYear(int year);
    Movie getTemplate();
    Movie addMovie(Movie movie) throws Exception;
    Iterable saveMovies(List<Movie> movies);
}
