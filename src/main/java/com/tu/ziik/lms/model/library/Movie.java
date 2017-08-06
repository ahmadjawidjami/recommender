package com.tu.ziik.lms.model.library;

import com.tu.ziik.lms.model.Genre;
import com.tu.ziik.lms.model.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    private Long id;
    private String name;
    private Set<UserRating> userRatings;

    private Set<Genre> genres;

    private String releaseDate;
    private String trailerUrl;


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Movie() {
    }

//    public Movie(String name) {
//        this.name = name;
//        userRatings = new HashSet<>();
//    }

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "movie")
    public Set<UserRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(Set<UserRating> userRatings) {
        this.userRatings = userRatings;
    }


    @ManyToMany
    @JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> roles) {
        this.genres = roles;
    }


//    @ManyToMany
//    @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
//    public Set<Genre> getGenres() {
//        return genres;
//    }

    public void setRoles(Set<Genre> genres) {
        this.genres = genres;
    }
}
