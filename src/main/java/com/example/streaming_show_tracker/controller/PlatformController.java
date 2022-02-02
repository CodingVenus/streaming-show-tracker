package com.example.streaming_show_tracker.controller;


import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/platform")
public class PlatformController {

    private final PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping
    public List<Platform> getAllPlatforms() {
        return platformService.getAllPlatforms();
    }

    @GetMapping("{platformName}")
    public Platform getOnePlatform(@PathVariable(value = "platformName")String platformName) {
        return platformService.getPlatform(platformName);
    }


    @PostMapping
    public Platform createPlatform(@RequestBody Platform platformObject) {
        return platformService.createPlatform(platformObject);
    }

    @PutMapping("{platformId}")
    public Platform updatePlatform(@PathVariable(value = "platformId") Long platformId, @RequestBody Platform platformObject){
        return platformService.updatePlatform(platformId, platformObject);
    }

    @DeleteMapping("{platformId}")
    public String deleteCategory(@PathVariable(value = "platformId") Long platformId) {
        return platformService.deletePlatform(platformId);
    }
}