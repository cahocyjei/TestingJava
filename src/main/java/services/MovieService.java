package services;

import data.MovieRepositoryJdbc;
import model.Genre;
import model.Movie;
import java.util.List;

public class MovieService {

    private MovieRepositoryJdbc movieRepositoryJdbc;

    public MovieService(MovieRepositoryJdbc movieRepositoryJdbc) {
        this.movieRepositoryJdbc = movieRepositoryJdbc;
    }

    public List<Movie> findAll() {
        return movieRepositoryJdbc.findAll();
    }

    public List<Movie> findByGenre(Genre genre){
        return movieRepositoryJdbc.findByGenre(genre);
    }
}
