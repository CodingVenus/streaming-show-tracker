package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.exceptions.InformationNotFoundException;
import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.repository.PlatformRepository;
import com.example.streaming_show_tracker.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    private PlatformRepository platformRepository;

    @Autowired
    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    //GET METHOD
    public List<Platform> getAllPlatforms() {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(userDetails.getUser().getId());

        List<Platform> platform = platformRepository.findByUserId(userDetails.getUser().getId());

        if (platform.isEmpty()) {
            throw new InformationNotFoundException("No platform listings found for user id " + userDetails.getUser().getId());
        } else {
            return platform;
        }
    }

    //


}
