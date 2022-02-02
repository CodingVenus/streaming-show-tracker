package com.example.streaming_show_tracker.repository;

import com.example.streaming_show_tracker.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {

    List<Platform> findByUserId(Long id);

}
