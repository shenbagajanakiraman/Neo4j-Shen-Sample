package com.stackroute.neo.repository;

import com.stackroute.neo.domain.Movie;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository <Movie,Long >{


    @Query("MATCH (m:Movie) WHERE m.id={movieId} SET m.name={movieName},m.duration={duration} RETURN m")
    Movie updateMovie(long movieId, String movieName, int duration);



    @Query("CREATE (s:Movie) SET s.id={movieId},s.name={movieName},s.duration={duration} RETURN s")
    public Movie saveNode(Long movieId, String movieName, int duration);


}
