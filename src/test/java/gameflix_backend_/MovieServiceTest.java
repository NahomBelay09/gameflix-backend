package gameflix_backend_;

import gameflix_backend_.model.Movie;
import gameflix_backend_.service.MovieService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        assertFalse(movies.isEmpty(), "Movie list should not be empty");
    }

    @Test
    void getMovieById_ShouldReturnMovie() {
        var movie = movieService.getMovieById(1L);
        assertNotNull(movie, "Movie should not be null");
    }

    @Test
    void addMovie_ShouldIncreaseListSize() {
        int initialSize = movieService.getAllMovies().size();
        Movie newMovie = new Movie(null, "Test Movie", "Test Genre");
        movieService.addMovie(newMovie);
        assertTrue(movieService.getAllMovies().size() > initialSize, "List size should increase");
    }
}
