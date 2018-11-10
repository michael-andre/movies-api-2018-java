package fr.cs.sio.moviesapi.data.flat;

import fr.cs.sio.moviesapi.data.MoviesRepository;
import fr.cs.sio.moviesapi.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete implementation of @{MoviesRepository} that will store data in-memory.
 * The implementation relies on a predefined list of hard-coded movies.
 */
// This concrete repository implements the MoviesRepository interface.
public class MoviesRepositoryImpl implements MoviesRepository {

    // Java: Define a static member to hold the single instance of the singleton.
    private static MoviesRepositoryImpl sInstance;

    // Java: Expose a public static method to access the instance of the singleton.
    public static MoviesRepositoryImpl getInstance() {
        // Java; Initialize the singleton instant lazily (if needed).
        if (sInstance == null) sInstance = new MoviesRepositoryImpl();
        return sInstance;
    }

    // Java: Make constructor private for singleton.
    private MoviesRepositoryImpl() {
    }

    // Keep an internal variable of all movies.
    private List<Movie> mAllMovies;

    // Java: A simple block inside a class is executed when the class is instantiated (before the constructor).
    {
        mAllMovies = new ArrayList<>();
        Movie m1 = new Movie();
        m1.setId(1);
        m1.setTitle("La Grande Vadrouille");
        mAllMovies.add(m1);
    }

    // Implement the query to list all movies (simply return our internal implementation).
    //TODO: Support filtering movies with optional parameters.
    @Override
    public List<Movie> getMovies() {
        return mAllMovies;
    }

    // Implement the query to a single movie.
    @Override
    public Movie getMovie(long id) {
        // Java: This syntax, instead of a basic loop, uses the "Stream" API (available in Java 8) to filter items.
        return mAllMovies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

}