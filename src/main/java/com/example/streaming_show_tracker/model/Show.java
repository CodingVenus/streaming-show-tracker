package com.example.streaming_show_tracker.model;


public class Show {

    private Long Id;
    private String name;
    private String genre;
    private String description;
    private Integer year;
    private String watchStatus;

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



}
