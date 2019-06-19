package com.stackroute.neo.service;

import com.stackroute.neo.domain.Movie;
import com.stackroute.neo.domain.User;
import com.stackroute.neo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);

    }

    @Override
    public void deleteAllMovies() {

    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void deleteMovie(Long id) {

    }

    @Override
    public Movie saveMovie(Long id, String name, Integer duration) {

        return movieRepository.saveNode(id,name,duration);


    }

    @Override
    public Collection<Movie> getAll() {
        return null;
    }
}
