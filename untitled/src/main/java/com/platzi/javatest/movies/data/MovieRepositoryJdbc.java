package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Movie findbyId(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id=?;", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }
    //tengo problemas con este método
    public Collection<Movie> findByName(String name) {
        name = name.toLowerCase();
        return jdbcTemplate.query("SELECT * FROM movies WHERE lower(name) like ?", movieMapper,"%" + name + "%");
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")));

        @Override
        public void saveOrUpdate(Movie movie) {
            jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) VALUES (?,?,?);", movie.getName(), movie.getMinutes(), movie.getGenre().toString());
        }
    }
