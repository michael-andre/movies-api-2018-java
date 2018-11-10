package fr.cs.sio.moviesapi.model;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * A model class to represent a movie.
 */
// Keep model class simple, with only properties to store the information.
public class Movie {

    private long mId;

    private String mTitle;

    // We chose to expose the relationship with cast and crew members with a List of Person instances.
    // This choice was mainly dictated by the need to easily expose this information to clients of our API.
    // But when *persisting* data, we will rely on a dedicated mechanism, that will vary with the storage layer.
    // For a database, it will probably involve ids, foreign keys, joins, join tables, etc.
    private List<Person> mActors;

    private List<Person> mDirectors;

    private Date mReleaseDate;

    // The platform contains a dedicated type for a set of enum values, with a very optimized implementation.
    private EnumSet<Genre> mGenres;

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public List<Person> getActors() {
        return mActors;
    }

    public void setActors(List<Person> mActors) {
        this.mActors = mActors;
    }

    public List<Person> getDirectors() {
        return mDirectors;
    }

    public void setDirectors(List<Person> mDirectors) {
        this.mDirectors = mDirectors;
    }

    public Date getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(Date mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public EnumSet<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(EnumSet<Genre> mGenres) {
        this.mGenres = mGenres;
    }

    // We can override (redefine) the toString() method to log something meaningful (e.g. for logging).
    @Override
    public String toString() {
        return String.format("Movie: %d: %s", mId, mTitle);
    }

}
