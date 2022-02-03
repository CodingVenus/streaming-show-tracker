package com.example.streaming_show_tracker.controller;

import com.example.streaming_show_tracker.model.Show;
import com.example.streaming_show_tracker.service.ShowService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/")
public class ShowController {

    public ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("platform/id/{platformId}/show")
    public List<Show> getAllShowsByPlatformId(@PathVariable(value="platformId") Long platformId){
        return showService.getAllShowsByPlatformId(platformId);
    }

    @GetMapping("platform/name/{platformName}/show")
    public List<Show> getAllShowsByPlatformName(@PathVariable(value="platformName") String platformName){
        return showService.getAllShowsByPlatformName(platformName);
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

    @PostMapping("platform/id/{platformId}/show")
    public Show createShowByPlatformId(@PathVariable(value="platformId") Long platformId, @RequestBody Show showObject){
        return showService.createShowByPlatformId(platformId, showObject);
    }

    @PostMapping("platform/name/{platformName}/show")
    public Show createShowByPlatformName(@PathVariable(value="platformName") String platformName, @RequestBody Show showObject){
        return showService.createShowByPlatformName(platformName, showObject);
    }

    @DeleteMapping("show/{showId}")
    public String deleteShow(@PathVariable(value="showId") Long showId) {
            return showService.deleteShow(showId);
        }


    @PutMapping("show/{showId}")
    public Show updateShow(@PathVariable(value = "showId") Long showId, @RequestBody Show showObject){

        return showService.updateShow(showId, showObject);

    }

//    @PatchMapping("show/{showId}")
//    public Show updateShowPatch(@PathVariable(value = "showId") Long showId, @RequestBody Map<Show, Show> showObject){
//
//        return showService.updateShowPatch(showId, showObject);
//
//    }




}
