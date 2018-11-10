package fr.cs.sio.moviesapi.services;

import fr.cs.sio.moviesapi.data.MoviesRepository;
import fr.cs.sio.moviesapi.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * An API endpoint to access a list of movies.
 * This endpoint only supports the HTTP method GET.
 */
// A Servlet class must have the @WebServlet annotation to be bounded to requests when the server runs.
// The "name" parameter in only relevant to identify the servlet internally.
// The "value" parameter defines a list of URL patterns that will be routed to this servlet.
@WebServlet(name = "Movies", value = "/movies")
// This class extends ApiEndpoint, our base class for all API endpoint servlets.
public class MoviesEndpoint extends ApiEndpoint {

    // In a servlet class, simply override the do***() methods to add support for a HTTP method.
    // Such methods return nothing, they must use the "response" parameter to send content to the client.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do NOT call super.doGet() in this case, since the parent implementation will send an error response!

        //TODO: Here we could parse query parameters and pass them to the repository.
        //String title = request.getParameter("title");

        // Obtain the unique instance of the MoviesRepository, and get a list of movies.
        List<Movie> movies = MoviesRepository.getInstance().getMovies();

        // Use our utility method from the parent class to send the response (protected access is OK in a child class).
        sendJsonResponse(response, movies);

    }

}
