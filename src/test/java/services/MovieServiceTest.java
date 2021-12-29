package services;

import data.MovieRepositoryJdbc;
import model.Genre;
import model.Movie;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class MovieServiceTest {
    private DataSource dataSource;

   @Test
    void return_movie_find_all() throws SQLException {
       dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");
       ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       MovieRepositoryJdbc movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
       List<Movie> movies = movieRepositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(new Movie(1,"Cenicienta","Colombia","1980",Genre.DRAMA,154,10),
                new Movie(2,"Guerreros","Argentina","1970",Genre.ACTION,134,15),
                new Movie(3,"El Capo","España","2018",Genre.ACTION,180,30),
                new Movie(4,"Obsesion","Italia","2001",Genre.COMEDIA,220,25)
        )));

    }


    @After
    public void tearDown() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}