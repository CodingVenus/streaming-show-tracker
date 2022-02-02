package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.exceptions.InformationNotFoundException;
import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.model.Show;
import com.example.streaming_show_tracker.repository.ShowRepository;
import com.example.streaming_show_tracker.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }


    public List<Show> getAllShows(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Platform> platform = showRepository.findByUserId(userDetails.getUser().getId());

        if (platform.isEmpty()) {
            throw new InformationNotFoundException("No platform listings found for User ID " + userDetails.getUser().getId());
        } else {
            return platform;
        }
    }


}
