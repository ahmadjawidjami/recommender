package com.tu.ziik.lms.repository;

import com.sun.tools.javah.Gen;
import com.tu.ziik.lms.model.Genre;
import com.tu.ziik.lms.model.lecturer.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ahmadjawid on 8/5/17.
 */

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
