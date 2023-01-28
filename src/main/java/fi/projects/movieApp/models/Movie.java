package fi.projects.movieApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movies")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "movie_name")
    @NonNull
    private String name;
    @NonNull
    private int year;
    @Embedded
    @CollectionTable(name = "genres")
    @ElementCollection(targetClass=Genre.class)
    private List<Genre> genres = new ArrayList<>();
    private int ageLimit;
    private int rating;
    @Embedded
    @CollectionTable(name = "actors")
    @ElementCollection(targetClass=Person.class)
    private List<Person> actors = new ArrayList<>();
    @Embedded
    private Person director = new Person();
    private String synopsis;

}
