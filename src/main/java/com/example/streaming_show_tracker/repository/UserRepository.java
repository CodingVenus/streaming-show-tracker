package com.example.streaming_show_tracker.repository;

import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.model.Show;
import com.example.streaming_show_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String userEmailAddress);

    User findUserByEmailAddress(String userEmailAddress);

}
