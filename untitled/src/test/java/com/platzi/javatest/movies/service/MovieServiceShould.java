package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;
    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1,"Dark Knight",152, Genre.ACTION),
                new Movie(2, "Memento", 113,Genre.THRILLER),
                new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                new Movie(4,"Super 8", 112, Genre.THRILLER),
                new Movie(5,"Scream",111, Genre.HORROR),
                new Movie(6,"Home Alone",103, Genre.COMEDY ),
                new Movie(7,"Matrix",136, Genre.ACTION)
        ));

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void returnMoviesByGenre() {


        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 6)));
    }

    @Test
    public void returnMoviesByDuration() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(movie -> movie.getId()).collect((Collectors.toList()));
    }
}