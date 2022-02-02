package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    private PlatformRepository platformRepository;

    @Autowired
    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    //GETTER
//    public List<Platform> getAllPlatforms() {
//    }
//

}
