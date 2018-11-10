package fr.cs.sio.moviesapi.model;

import java.util.EnumSet;

/**
 * A model class to represent a person.
 * Persons can be part of the cast (actors) and/or the crew (directors, etc.) of a movie.
 */
public class Person {

    // Java: Use encapsulation with private fields and public getter/setter.
    private long mId;

    private String mFirstName;

    private String mLastName;

    // This information is *redundant* with the presence or absence of this Person in the lists of a movie.
    // But we can keep it if it adds value to our API clients.
    // Maybe we will not *store* it, but instead compute it from other relations.
    private EnumSet<Role> mRoles;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public EnumSet<Role> getRoles() {
        return mRoles;
    }

    public void setRoles(EnumSet<Role> roles) {
        this.mRoles = roles;
    }

}
