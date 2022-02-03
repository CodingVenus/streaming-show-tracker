package com.example.streaming_show_tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="platforms")
public class Platform {

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;




    //MAPPING TO SHOW TABLE
    @OneToMany(mappedBy = "platform", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Show> showList;

            //SHOW GETTERS AND SETTERS
    public List<Show> getShowList() {
        return showList;
    }
    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }



    //MAPPING TO USER TABLE
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

            //SHOW GETTERS AND SETTERS
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }



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
