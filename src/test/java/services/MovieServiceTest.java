package services;

import data.MovieRepositoryJdbc;
import model.Genre;
import model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.jdbc.datasource.init.ScriptUtils.executeSqlScript;


class MovieServiceTest {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");
        executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

   @Test
    void return_movie_find_all() {

       MovieRepositoryJdbc movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

        assertThat(movieRepositoryJdbc.findAll(), is(Arrays.asList(new Movie(1,"Cenicienta","Colombia","1980",Genre.DRAMA,154,10),
                new Movie(2,"Guerreros","Argentina","1970",Genre.ACTION,134,15),
                new Movie(3,"El Capo","España","2018",Genre.ACTION,180,30),
                new Movie(4,"Obsesion","Italia","2001",Genre.COMEDIA,220,25)
        )));

    }

    @Test
    void return_movies_find_by_genre() {
        MovieRepositoryJdbc movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

        assertThat(movieRepositoryJdbc.findByGenre(Genre.ACTION), is(Arrays.asList(
                new Movie(2, "Guerreros", "Argentina",
                        "1970", Genre.ACTION, 134, 15),
                new Movie(3, "El Capo", "España",
                        "2018", Genre.ACTION, 180, 30))));
    }

    @AfterEach
    void tearDown() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }

}