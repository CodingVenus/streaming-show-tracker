package com.example.streaming_show_tracker.controller;

import com.example.streaming_show_tracker.model.Show;
import com.example.streaming_show_tracker.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class ShowController {

    public ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("platform/{platformId}/show")
    public List<Show> getAllShowsByPlatform(@PathVariable(value="platformId") Long platformId){
        return showService.getAllShowsByPlatform(platformId);
    }

    @GetMapping("show")
    public List<Show> getAllShowsByUserId(){
        return showService.getAllShowsByUserId();
    }

    @GetMapping("show/id/{showId}")
    public Show getShowById(@PathVariable(value="showId") Long showId){
        return showService.getShowById(showId);
    }

    @GetMapping("show/name/{showName}")
    public Show getShowByName(@PathVariable(value="showName") String showName){
        return showService.getShowByName(showName);
    }


}
