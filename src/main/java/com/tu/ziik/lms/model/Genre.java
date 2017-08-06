package com.tu.ziik.lms.model;

import com.tu.ziik.lms.model.library.Movie;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ahmadjawid on 8/5/17.
 */

@Entity
@Table(name = "genres")
public class Genre {


    private Long id;

    private String name;


    private Set<Movie> movies;


    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    @ManyToMany(mappedBy = "genres")
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
