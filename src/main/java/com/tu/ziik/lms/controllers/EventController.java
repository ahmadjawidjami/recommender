package com.tu.ziik.lms.controllers;

import com.tu.ziik.lms.model.Event;
import com.tu.ziik.lms.model.User;
import com.tu.ziik.lms.model.library.Movie;
import com.tu.ziik.lms.model.library.UserRating;
import com.tu.ziik.lms.repository.UserRepository;
import com.tu.ziik.lms.service.admin.event.EventService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ahmadjawid on 1/29/17.
 */

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/user/rated/items", method = RequestMethod.GET)
	public String listEvents(Model model) {

		User user = userRepository.findOne((long) 10);
		List<UserRating> ratings = new ArrayList(user.getUserRatings());

		Collections.sort(ratings, (r1, r2) -> r2.getRating() - r1.getRating());
		
		List<Movie> movies = new ArrayList();
		Map<String, Double> est_rates = new HashMap<String, Double>();
		
		for (UserRating s : ratings) {
			movies.add(s.getMovie());
			est_rates.put(s.getMovie().getId()+"", (double)s.getRating());
			
		}
		model.addAttribute("items", movies);
		model.addAttribute("Est_Rate", est_rates);

		return "welcome";
	}

	@RequestMapping(value = "/admin/event/add", method = RequestMethod.GET)
	public String addEvent(Model model) {

		model.addAttribute("event", new Event());

		return "admin/event/event-form";
	}

	@RequestMapping(value = "/admin/event/add", method = RequestMethod.POST)
	public String addEvent(@ModelAttribute("event") Event event) {

		eventService.saveEvent(event);

		return "redirect:/admin/event/list";
	}
}
