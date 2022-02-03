package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.exceptions.InformationNotFoundException;
import com.example.streaming_show_tracker.model.Platform;
import com.example.streaming_show_tracker.model.Show;
import com.example.streaming_show_tracker.repository.PlatformRepository;
import com.example.streaming_show_tracker.repository.ShowRepository;
import com.example.streaming_show_tracker.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private ShowRepository showRepository;
    private PlatformRepository platformRepository;


    public ShowService(ShowRepository showRepository, PlatformRepository platformRepository) {
        this.showRepository = showRepository;
        this.platformRepository = platformRepository;
    }

    //GET ALL SHOWS BY PLATFORM
    public List<Show> getAllShowsByPlatform(Long platformId){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Platform platform = platformRepository.findByIdAndUserId(platformId, userDetails.getUser().getId());

        if (platform == null) {
            throw new InformationNotFoundException("Category with ID " + platformId +
                    " does not belongs to this user or the category does not exist");
        }
        return platform.getShowList();
    }

    //GET ALL SHOWS BY USER
    public List<Show> getAllShowsByUserId(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        List<Show> show = showRepository.findByUserId(userDetails.getUser().getId());

        if (show == null) {
            throw new InformationNotFoundException("User with ID " + userDetails.getUser().getId() +
                    " does not have any shows.");
        }
        return show;
    }


    //GET SHOW BY ID

    public Show getShowById(Long showId) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Show show = showRepository.findByIdAndUserId(showId, userDetails.getUser().getId());

        if (show == null) {
            throw new InformationNotFoundException("Show with ID " + showId + " was not found.");
        } else {
            return show;
        }
    }


    //GET SHOW BY NAME

    public Show getShowByName(String showName) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Show show = showRepository.findByUserIdAndNameIgnoreCase(userDetails.getUser().getId(), showName);

        if (show == null) {
            throw new InformationNotFoundException("Show with name " + showName + " was not found.");
        } else {
            return show;
        }
    }


}
