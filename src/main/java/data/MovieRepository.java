package data;

import model.Genre;
import model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<Movie> findAll();
    List<Movie> findByGenre(Genre genre);
    List<Movie> findById(Integer id);
}
