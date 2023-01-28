package fi.projects.movieApp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fi.projects.movieApp.models.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.projects.movieApp.services.MovieService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class MovieAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MovieService movieService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Movie>> typeReference = new TypeReference<>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json_data/movies-compact.json");
			try {
				List<Movie> movies = mapper.readValue(inputStream,typeReference);
				movieService.saveMovies(movies);
				System.out.println("Movies Saved!");
				System.out.println(movies);
			} catch (IOException e){
				System.out.println("Unable to save movies: " + e.getMessage());
			}
		};
	}

}
