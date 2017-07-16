package com.tu.ziik.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.ziik.lms.model.library.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
