package fi.projects.movieApp;

import fi.projects.movieApp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fi.projects.movieApp.services.IMovieService;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private IMovieService service;
    @Autowired
    public MovieController(IMovieService service) {
        this.service = service;
    }

    @GetMapping
    List<Movie> getMovies() {
        return service.getMovies();
    }

    @GetMapping("/search")
    List<Movie> searchMoviesByNamePart(@RequestParam String name) {
        return service.getMoviesByName(name);
    }

    @GetMapping("/{year}")
    List<Movie> getMoviesByYear(@PathVariable int year) {
        return service.getMoviesByYear(year);
    }

    @GetMapping("/template")
    Movie getTemplate() {
        return service.getTemplate();
    }

    // Could be PutMapping and handle changes to existing movies as well
    @PostMapping("/new")
    Movie addMovie(@RequestBody Movie movie) throws Exception {
        Movie returnMovie;
        try {
            returnMovie = service.addMovie(movie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return returnMovie;
    }

}
