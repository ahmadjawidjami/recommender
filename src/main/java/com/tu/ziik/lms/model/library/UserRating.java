package com.tu.ziik.lms.model.library;

import com.tu.ziik.lms.model.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(EmployeeId.class)
public class UserRating implements Serializable {
	private Movie movie;
	private User user;
	private String timestamp;
	private int rating;


//	private Long theId;
//
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public Long getTheId() {
//		return theId;
//	}
//
//	public void setTheId(Long theId) {
//		this.theId = theId;
//	}

	@Column(name = "timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "item_id")
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
