package com.stackroute.neo.controller;

import com.stackroute.neo.domain.Movie;
import com.stackroute.neo.domain.User;
import com.stackroute.neo.service.MovieService;
import com.stackroute.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping(value= "/api/v1/neo")
public class MovieController {

    @Autowired
    MovieService movieService;

//    @GetMapping
//    public Collection<Movie> getAll(){
//        return movieService.getAll();
//    }

    @PostMapping(value="/movie")
    public ResponseEntity saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        movieService.saveMovie(movie.getId(),movie.getName(),movie.getDuration());
        responseEntity = new ResponseEntity (movie, HttpStatus.CREATED) ;

        return responseEntity;



    }

//
//    @DeleteMapping("/movie/{id}")
//    public String deleteMoviebyId(@PathVariable Long id) {
//        movieService.deleteMovie(id);
//        return "Deleted User";
//
//
//    }

//    @GetMapping("/movie/{name}")
//    public User getMovie(@PathVariable String name)    {
//
//        return movieService.findByName(name);
//    }

//    @DeleteMapping("/deleteMovies")
//    public String deleteAllMovies() {
//        movieService.deleteAllMovies();
//        return "Deleted All Users";
//
//
//    }

    @PutMapping("/movie/{id}")
    public Movie updateMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;

        return movieService.updateMovie(movie);
        //  return new ResponseEntity<String>("successfully", HttpStatus.CREATED);
    }
}

