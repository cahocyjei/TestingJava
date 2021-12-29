package data;

import model.Genre;
import model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    private static RowMapper<Movie> movieMapper= (rs, rowNum) -> new Movie(rs.getInt("id"),
            rs.getString("titulo"),rs.getString("pais"),
            rs.getString("fecha"),Genre.valueOf(rs.getString("genre")),
            rs.getDouble("duracion"),rs.getInt("capitulo"));


    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAll() {
        return  jdbcTemplate.query("SELECT * FROM movie", movieMapper);
    }

    @Override
    public List<Movie> findByGenre(Genre genre) {
        return jdbcTemplate.query("SELECT * FROM movie",movieMapper)
                .stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    @Override
    public List<Movie> findById(Integer id) {
        return null;
    }
}
