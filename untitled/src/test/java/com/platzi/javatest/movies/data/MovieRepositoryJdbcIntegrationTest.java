package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.ietf.jgss.GSSName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.swing.plaf.nimbus.State;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryJdbcIntegrationTest {
    MovieRepositoryJdbc movieRepositoryJdbc;
    DriverManagerDataSource driverManagerDataSource;
    Movie movie;

    @Before
    public void setUp() throws Exception {

        driverManagerDataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa","sa");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);

        ScriptUtils.executeSqlScript(driverManagerDataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

    }

    @Test
    public void loadAllMovies() throws SQLException {

        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertEquals(asList(
                new Movie(1,"Dark Knight",152, Genre.ACTION),
                new Movie(2, "Memento", 113,Genre.THRILLER),
                new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                new Movie(4,"Super 8", 112, Genre.THRILLER),
                new Movie(5,"Scream",111, Genre.HORROR),
                new Movie(6,"Home Alone",103, Genre.COMEDY ),
                new Movie(7,"Matrix",136, Genre.ACTION)
        ),movies);
    }

    @Test
    public void insertAMovie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);

        movieRepositoryJdbc.saveOrUpdate(movie);

        Movie movieLoaded = movieRepositoryJdbc.findbyId(4);

        assertEquals(movieLoaded, new Movie(4,"Super 8", 112, Genre.THRILLER));
    }

    @Test
    public void loadMoviesById() {
        Movie movie = movieRepositoryJdbc.findbyId(2);

        assertEquals(new Movie(2,"Memento",113, Genre.THRILLER),movie);
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = driverManagerDataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }

    @Test
    public void searchMovieByName() {
        Collection<Movie> movies = movieRepositoryJdbc.findByName("Super");

        assertEquals(Arrays.asList(
                new Movie(4, "Superman", 143, Genre.ACTION),
                new Movie(5, "Super 8", 112, Genre.THRILLER)
        ), movies);

    }
}