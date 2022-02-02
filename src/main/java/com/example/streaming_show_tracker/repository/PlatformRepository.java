package com.example.streaming_show_tracker.repository;

import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {

    List<Platform> findByUserId(Long id);
    Platform findByUserIdAndNameIgnoreCase(Long userId, String name);
    Platform findByIdAndUserId (Long categoryId, Long userId);

}
