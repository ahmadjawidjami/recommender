package com.tu.ziik.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tu.ziik.lms.model.library.Movie;
import com.tu.ziik.lms.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getItems(List<RecommendedItem> items) throws TasteException {
		List<Movie> movies = new ArrayList<Movie>();
		items.forEach(item -> movies.add(movieRepository.findOne( item.getItemID())));
		return movies;
	}

}
