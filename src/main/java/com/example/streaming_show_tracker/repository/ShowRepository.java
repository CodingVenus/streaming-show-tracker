package com.example.streaming_show_tracker.repository;

import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByUserId(Long id);
    Show findByUserIdAndNameIgnoreCase(Long userId, String name);
    Show findByIdAndUserId (Long categoryId, Long userId);

}
