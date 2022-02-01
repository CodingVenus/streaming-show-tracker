package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.model.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    public List<Show> getShowList (){
      return List.of(
                new Show (
                        1L, "Supernatural", "romance", "it's good", 2013, "watched"
                )
        );
    }
}
