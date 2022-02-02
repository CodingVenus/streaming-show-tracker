package com.example.streaming_show_tracker.repository;

import com.example.streaming_show_tracker.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {


}
