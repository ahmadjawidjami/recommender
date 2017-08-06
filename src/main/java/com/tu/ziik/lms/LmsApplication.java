package com.tu.ziik.lms;


		import com.tu.ziik.lms.model.User;
		import com.tu.ziik.lms.model.library.Movie;
		import com.tu.ziik.lms.model.library.UserRating;
		import com.tu.ziik.lms.repository.GenreRepository;
		import com.tu.ziik.lms.repository.MovieRepository;
		import com.tu.ziik.lms.repository.UserRatingRepository;
		import com.tu.ziik.lms.repository.UserRepository;
		import com.tu.ziik.lms.storage.StorageProperties;
		import com.tu.ziik.lms.storage.StorageService;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.context.properties.EnableConfigurationProperties;
		import org.springframework.context.annotation.Bean;
		import org.springframework.data.domain.PageRequest;
		import org.springframework.data.domain.Pageable;
		import org.springframework.jdbc.core.JdbcTemplate;

		import java.util.HashSet;
		import java.util.List;
		import java.util.Set;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class LmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRatingRepository userRatingRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {


		Pageable limit = new PageRequest(0,10);
		movieRepository.findAll(limit);

		//Find movies which has a specific genre
		List<Movie> movies = movieRepository.findByGenres(genreRepository.findOne(new Long(2)), limit);

		for (Movie movie: movies){
			System.out.println(movie.getName());
		}


//		User user = userRepository.findOne(new Long(945));
//
//		Movie movie = movieRepository.findOne(new Long(1));
//
//	//	Set<UserRating> userRatings = user.getUserRatings();
//
//
//
//		UserRating userRating2 = new UserRating();
//		userRating2.setUser(user);
//
//		//Movie should already exist and you find it using movieRepository
//		userRating2.setMovie(movie);
//		userRating2.setRating(5);
//
//		UserRating userRating1 = new UserRating();

		//Couldn't manage to insert using Jpa so used simple jdbc.
		//Consider the duplicate error before every insert.
		jdbcTemplate.execute("INSERT INTO user_rating VALUES (5, 'time', 945, 2)");


	}
}

