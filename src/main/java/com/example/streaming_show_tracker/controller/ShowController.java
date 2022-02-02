package com.example.streaming_show_tracker.controller;

import com.example.streaming_show_tracker.model.Show;
import com.example.streaming_show_tracker.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/show")
public class ShowController {

    public ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getShowList(Long platformId){
        return showService.getAllShows(platformId);
    }

}
