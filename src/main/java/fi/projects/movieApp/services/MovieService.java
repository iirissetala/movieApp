package fi.projects.movieApp.services;

import fi.projects.movieApp.MovieRepository;
import fi.projects.movieApp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    private MovieRepository repository;
    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @Override
    public List<Movie> getMoviesByName(String name) {
        return repository.findMoviesByNamePart(name);
    }

    @Override
    public List<Movie> getMoviesByYear(int year) {
        return repository.findMoviesByYear(year);
    }

    @Override
    public Movie getTemplate() {
        return new Movie();
    }

    @Override
    public Movie addMovie(Movie movie) throws Exception {
        //TODO: implement own error class and exception handling
        Movie exists = repository.findMovieByName(movie.getName().toLowerCase());
        if (exists != null) {
            throw new Exception("Movie with name " + movie.getName() + " already listed!");
        }
        return repository.save(movie);
    }

    @Override
    public Iterable<Movie> saveMovies(List<Movie> movies) {
        return repository.saveAll(movies);
    }
}
