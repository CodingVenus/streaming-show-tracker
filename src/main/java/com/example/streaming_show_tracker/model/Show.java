package com.example.streaming_show_tracker.model;


import javax.persistence.*;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String genre;
    private String description;
    private Integer year;
    private String watchStatus;

    //CONSTRUCTORS
    public Show() {
    }

    public Show(Long id, String name, String genre, String description, Integer year, String watchStatus) {
        this.Id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.watchStatus = watchStatus;
    }

    //GETTERS AND SETTERS
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    @Override
    public String toString() {
        return "Show{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", watchStatus='" + watchStatus + '\'' +
                '}';
    }
}
