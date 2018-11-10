package fr.cs.sio.moviesapi.data;

import fr.cs.sio.moviesapi.data.flat.MoviesRepositoryImpl;
import fr.cs.sio.moviesapi.model.Movie;

import java.util.List;

/**
 * A base interface for a repository of Movie entities.
 *
 */
// Repository interfaces and classes constitute the data layer of our API.
// As a best practice, we ony describe here the capabilities of a repository (list of methods).
// Concrete classes will be defined to implement if with a database, in-memory storage, etc.
// Outside the data package, other layers should only deal with this interface, and know nothing about implementations.
//TODO: Define additional repository for Persons.
public interface MoviesRepository {

    /**
     * Get all movies from the repository.
     */
    //TODO: Add optional parameters or variants to filter movies.
    List<Movie> getMovies();

    /**
     * Find a movie by id.
     * If the movie does not exist, null is returned.
     */
    Movie getMovie(long id);

    //TODO: Add methods for other possible queries related to movies, or closely related.
    //Genre[] getGenres();

    // Java: Expose a static method for other layers to obtain the single repository instance.
    static MoviesRepository getInstance() {
        // Java: Delegate to the singleton implemented in MoviesRepositoryImpl.
        return MoviesRepositoryImpl.getInstance();
    }

}
