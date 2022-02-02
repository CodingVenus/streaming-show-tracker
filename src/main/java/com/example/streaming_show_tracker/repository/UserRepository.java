package com.example.streaming_show_tracker.repository;

import com.example.streaming_show_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    boolean existsByEmailAddress(String userEmailAddress);

    User findUserByEmailAddress(String userEmailAddress);

}
