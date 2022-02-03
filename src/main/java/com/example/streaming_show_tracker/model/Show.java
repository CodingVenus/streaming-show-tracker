package com.example.streaming_show_tracker.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "shows")
public class Show {

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String description;
    private Integer year;
    private String watchStatus;
    @Transient
    private String platformName;



    //MAPPING TO PLATFORM TABLE
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "platform_id")
    private Platform platform;

        //PLATFORM GETTERS AND SETTERS
    public Platform getPlatform() {
        return platform;
    }
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }


    //MAPPING TO USER TABLE
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

            //USER GETTERS AND SETTERS
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



    //CONSTRUCTORS
    public Show() {
    }

    public Show(Long id, String name, String genre, String description, Integer year, String watchStatus) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.watchStatus = watchStatus;
    }

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getWatchStatus() {
        return watchStatus;
    }

    public void setWatchStatus(String watchStatus) {
        this.watchStatus = watchStatus;
    }

    public String getPlatformName() {
        return this.platform.getName();
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "Show{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", watchStatus='" + watchStatus + '\'' +
                '}';
    }
}
