package fi.projects.movieApp;


import fi.projects.movieApp.models.Movie;

import fi.projects.movieApp.services.IMovieService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MoviesTest {
    @Autowired
    private MockMvc mock;
    @Autowired
    IMovieService service;

    private static final String GET_PATH = "/api/movies";

    @Test
    void getMovieslistOk() throws Exception {
        ResultActions result = this.mock.perform(get(GET_PATH))
                .andExpect(status().isOk());
    }

    // passes only if no movies are added after running the app (20 movies in json file)
    @Test
    void getMoviesListFromServiceOk() {
        List<Movie> movies = service.getMovies();
        Assert.assertNotNull(movies);
        Assert.assertFalse(movies.isEmpty());
        Assert.assertEquals(20, movies.size());
    }

}
