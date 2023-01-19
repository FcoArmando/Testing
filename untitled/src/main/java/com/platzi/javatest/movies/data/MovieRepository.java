package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findbyId(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);

    Collection<Movie> findByName(String name);
}
