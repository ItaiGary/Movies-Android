package com.example.movies;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping(value ="movie")

public class MovieController{

	private static Map<Integer,Movie> movies = new HashMap<>();
    private static int counter = 6;
    static String url_MORTAL_KOMBAT = "https://image.tmdb.org/t/p/original/quwcbufZZiTMUjuiGSLKBkWWaga.jpg";
    static String url_FOREST_GUMP = "https://fanart.tv/fanart/movies/13/movieposter/forrest-gump-52196a490f738.jpg";
    static String url_PAY_IT_FORWARD = "https://ndiahpangastuti.files.wordpress.com/2012/06/pay-it-forward-1.jpg";
    static String url_MOANA = "https://image.tmdb.org/t/p/original/pp6Cd5XuTiMsWZE6dTPp97J8Byr.jpg";
    static String url_BROTHER_BEAR = "http://img3.wikia.nocookie.net/__cb20140317235209/disney/images/8/86/Brother_Bear_Poster.png";
    
    static {
        movies.put(1, new Movie("Mortal Kombat", "8", "Shmuel nirma & Simha sason", url_MORTAL_KOMBAT));
        movies.put(2, new Movie("Forrest Gump", "10", " Tom Hanks, Robin Wright, Gary Sinise, Mykelti Williamson, and Sally Field", url_FOREST_GUMP));
        movies.put(3, new Movie("Pay It Forward", "9.2", "Haley Joel Osment, Helen Hunt and Kevin Spacey", url_PAY_IT_FORWARD));
        movies.put(4, new Movie("Moana", "11", "Auli'i Cravalho, Dwayne Johnson, Rachel House ", url_MOANA));
        movies.put(5, new Movie("Brother bear", "12", "Kenai, Sitka, ", url_BROTHER_BEAR));

    }

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Movie> getAllMovies() {
		return movies.values();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int addMovie(@RequestBody Movie movie) {
		if (movie != null) {
			movies.put(counter++,movie);
			return 1;
		}
		return -1;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public int removeMovie(@PathVariable int id) {
		if(movies.remove(id) != null) {
			return 1;
		}
		return -1;
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Movie getMovieById(@PathVariable int id) {
		return movies.get(id);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public int updateMovie(@PathVariable int id,@RequestBody Movie movie) {
		if(movies.containsKey(id)) {
			if(movie != null) {
				movies.put(id,movie);
				return 1;
			}
		}
		return -1;
		
	}
	
	
}