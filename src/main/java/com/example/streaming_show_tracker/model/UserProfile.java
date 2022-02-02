package com.example.streaming_show_tracker.model;

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

}
