package com.stackroute.neo.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;



@NodeEntity
public class Movie {

    @GraphId
    private Long id;
    private String name;
    private Integer duration;

    public Movie() {
    }

    public Movie(Long id, String name, Integer duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}




