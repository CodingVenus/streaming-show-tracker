package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.exceptions.InformationExistsException;
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

    //GET METHODS

    //GET ALL SHOWS BY PLATFORM
    public List<Show> getAllShowsByPlatformId(Long platformId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Platform platform = platformRepository.findByIdAndUserId(platformId, userDetails.getUser().getId());

        if (platform == null) {
            throw new InformationNotFoundException("Platform with ID " + platformId +
                    " does not belongs to this user or the category does not exist");
        }
        return platform.getShowList();
    }

    //GET ALL SHOWS BY PLATFORM
    public List<Show> getAllShowsByPlatformName(String platformName) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Platform platform = platformRepository.findByUserIdAndNameIgnoreCase(userDetails.getUser().getId(), platformName);

        if (platform == null) {
            throw new InformationNotFoundException("Platform with ID " + platformName +
                    " does not belongs to this user or the category does not exist");
        }
        return platform.getShowList();
    }

    //GET ALL SHOWS BY USER
    public List<Show> getAllShowsByUserId() {
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

    //POST METHODS
    //POST SHOW BY PLATFORM ID
    public Show createShowByPlatformId(Long platformId, Show showObject) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Platform platform = platformRepository.findByIdAndUserId(platformId, userDetails.getUser().getId());

        if (platform == null) {
            throw new InformationNotFoundException(
                    "Platform with ID " + platformId + " is not listed under this User or the platform does not exist.");
        }
        return getShow(showObject, userDetails, platform);

    }

    //POST SHOW BY PLATFORM NAME
    public Show createShowByPlatformName(String platformName, Show showObject) {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Platform platform = platformRepository.findByUserIdAndNameIgnoreCase(userDetails.getUser().getId(), platformName);

        if (platform == null) {
            throw new InformationNotFoundException(
                    "Platform with Name " + platformName + " is not listed under this User or the platform does not exist.");
        }
        return getShow(showObject, userDetails, platform);

    }
    //METHOD USED IN POST METHODS TO STOP DUPLICATE CODE
    public Show getShow(Show showObject, MyUserDetails userDetails, Platform platform) {
        Show show = showRepository.findByUserIdAndNameIgnoreCase(userDetails.getUser().getId(), showObject.getName());
        if (show != null) {
            throw new InformationExistsException("Show with the name " + show.getName() + " already exists.");
        }
        showObject.setUser(userDetails.getUser());
        showObject.setPlatform(platform);
        return showRepository.save(showObject);
    }


    //DELETE BY ID
    public String deleteShow(Long showId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Show show = showRepository.findByIdAndUserId(showId, userDetails.getUser().getId());
        if (show == null) {
            throw new InformationNotFoundException("Show with ID " + showId + " is not found.");
        } else {
            showRepository.deleteById(showId);
            return "Show Name: " + show.getName() + " Id: " + showId + " has been successfully deleted.";
        }
    }




    //UPDATE

}
