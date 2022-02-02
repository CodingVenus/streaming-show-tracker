package com.example.streaming_show_tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class UserProfile {

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String profileDescription;


    //MAPPING TO USER
    @JsonIgnore
    @OneToOne
    private User user;

            //GETTER AND SETTER FOR USER
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    //CONSTRUCTORS
    public UserProfile() {
    }

    public UserProfile(Long id, String firstName, String lastName, String profileDescription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileDescription = profileDescription;
    }


    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    //TO STRING

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                '}';
    }
}
