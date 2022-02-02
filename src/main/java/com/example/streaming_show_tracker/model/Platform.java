package com.example.streaming_show_tracker.model;

import javax.persistence.*;

@Entity
@Table(name="platforms")
public class Platform {

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    //CONSTRUCTORS
    public Platform() {
    }

    public Platform(Long id, String name) {
        this.id = id;
        this.name = name;
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


    //TO STRING
    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
