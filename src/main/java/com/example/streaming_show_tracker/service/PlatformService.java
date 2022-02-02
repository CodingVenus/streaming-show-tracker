package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.exceptions.InformationExistsException;
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

    //GET METHODS

            //GET ALL
    public List<Platform> getAllPlatforms() {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(userDetails.getUser().getId());

        List<Platform> platform = platformRepository.findByUserId(userDetails.getUser().getId());

        if (platform.isEmpty()) {
            throw new InformationNotFoundException("No platform listings found for User ID " + userDetails.getUser().getId());
        } else {
            return platform;
        }
    }

            //GET ONE BY ID
    public Platform getPlatformById(Long platformId) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Platform platform = platformRepository.findByIdAndUserId(platformId, userDetails.getUser().getId());

        if (platform == null) {
            throw new InformationNotFoundException("Platform with ID " + platformId + " was not found.");
        } else {
            return platform;
        }
    }


            //GET ONE BY NAME
    public Platform getPlatformByName(String platformName) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Platform platform = platformRepository.findByUserIdAndNameIgnoreCase(userDetails.getUser().getId(), platformName);

        if (platform == null) {
            throw new InformationNotFoundException("Platform with name " + platformName + " was not found.");
        } else {
            return platform;
        }
    }



    //POST
    public Platform createPlatform(Platform platformObject) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Platform platform = platformRepository.findByUserIdAndNameIgnoreCase(userDetails.getUser().getId(), platformObject.getName());

        if (platform != null)
        {
            throw new InformationExistsException("Platform with name " + platform.getName() + " already exists");
        } else {
            platformObject.setUser(userDetails.getUser());
            return platformRepository.save(platformObject);
        }
    }


    //PUT
    public Platform updatePlatform(Long platformId, Platform platformObject) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Platform platform = platformRepository.findByIdAndUserId(platformId, userDetails.getUser().getId());

        if (platform == null) {
            throw new InformationNotFoundException("Platform with ID of " + platformId + " is not found.");
        } else {
            platform.setName(platformObject.getName());
            platform.setUser(userDetails.getUser());
            return platformRepository.save(platform);
        }
    }

    //DELETE
    public String deletePlatform(Long platformId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Platform platform = platformRepository.findByIdAndUserId(platformId, userDetails.getUser().getId());
        if (platform == null) {
            throw new InformationNotFoundException("Platform with ID " + platformId + " is not found.");
        } else {
            platformRepository.deleteById(platformId);
            return "Platform Name: " + platform.getName() + " Id: " + platformId + " has been successfully deleted.";
        }
    }



}
