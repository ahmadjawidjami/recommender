package com.tu.ziik.lms.repository;

import com.tu.ziik.lms.model.library.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ahmadjawid on 8/6/17.
 */

//For now couldn't manage to use this
@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Long> {



}
