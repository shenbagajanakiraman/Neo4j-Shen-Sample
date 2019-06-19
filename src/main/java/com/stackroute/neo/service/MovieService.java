package com.stackroute.neo.service;

import com.stackroute.neo.domain.Movie;
import com.stackroute.neo.domain.User;

import java.util.Collection;

public interface MovieService {
   

    public Movie updateMovie(Movie movie);

    void deleteAllMovies();

    User findByName(String name);

    void deleteMovie(Long id);

    public Movie saveMovie(Long id, String name, Integer duration);

    Collection<Movie> getAll();
}
