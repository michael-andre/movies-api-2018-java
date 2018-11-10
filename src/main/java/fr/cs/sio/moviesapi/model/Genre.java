package fr.cs.sio.moviesapi.model;

/**
 * An enum for the genre of a movie.
 * See https://en.wikipedia.org/wiki/List_of_genres.
 */
// An enum is the perfect type for an information that can only take a single value from a predefined set.
public enum Genre {

    // Enum values are defined and accessed list constants.
    // Always use capital letters and underscores for enum values and constants.
    DRAMA,
    COMEDY,
    HORROR,
    FANTASTIC,
    SCIENCE_FICTION,
    ACTION,
    ADVENTURE,
    ROMANCE,
    DOCUMENTARY

}
