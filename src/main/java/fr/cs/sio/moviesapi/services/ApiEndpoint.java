package fr.cs.sio.moviesapi.services;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A base class for all our API endpoints.
 */
// This class extends the HttpServlet class, provided by the Java Servlet API (javax.servlet-api dependency).
// This class has no abstract methods, neither do the parent class.
// But this is still a good practice to make it abstract because we intend it to be subclassed.
public class ApiEndpoint extends HttpServlet {

    /**
     * Utility method to write an abject to an @{HttpServletResponse} as JSON.
     * This method relies on the Gson library for encoding.
     */
    // Give protected visibility to this method for subclasses.
    // Java: This method can receive anything as "data" for encoding, so we chose the most generic "Object" type.
    // Java: The methods writing to the response can throw IOException (checked), we choose to propagate them.
    protected void sendJsonResponse(HttpServletResponse response, Object data) throws IOException {

        // The HTTP protocol requires that the MIME type of the response is sent as a "header" (metadata).
        // We can use response.setHeader() for this, but there are also shorthand setters for common headers.
        response.setContentType("application/json");

        // Then we can convert the data object to JSON an write to the response.
        response.getWriter().print(new Gson().toJson(data));

    }

}
