package com.tu.ziik.lms.repository;

import com.tu.ziik.lms.model.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.ziik.lms.model.library.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenres(Genre genre, Pageable limit);

}
