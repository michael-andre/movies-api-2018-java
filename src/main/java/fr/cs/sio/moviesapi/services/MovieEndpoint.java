package fr.cs.sio.moviesapi.services;

import fr.cs.sio.moviesapi.data.MoviesRepository;
import fr.cs.sio.moviesapi.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * An API endpoint to access a single movie by its id.
 * This endpoint only supports the HTTP method GET.
 */
// We can use * in the value to define a generic pattern that will match any URL starting with "/movies/".
// Though, we have no way to restrict it to digits only, so we will have to check it later.
@WebServlet(name = "Movie", value = "/movies/*")
public class MovieEndpoint extends ApiEndpoint {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Extract the id from the URL:
        // - getPathInfo() on HttpServletRequest gives us access to the path part of URL (after the domain).
        // - split() on String allows us to obtain each parts of the path as an array of Strings.
        // - Long.parseLong() converts a String into a Long (throws an exception if the string is not a proper number).
        String[] pathParts = request.getPathInfo().split("/");
        long id = Long.parseLong(pathParts[pathParts.length - 1]);
        //TODO: The previous lines will fail if the URL doesn't contain a proper id, we should handle this case.

        // Obtain the unique instance of the MoviesRepository, and get the movie.
        Movie movie = MoviesRepository.getInstance().getMovie(id);
        //TODO: Deal properly with the case where there is no movie with this id (404 error).

        sendJsonResponse(response, movie);

    }
}
