package com.First_Spring_Project_0323.tvMaze;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "tvMazeService",
        url = "${tvMaze.url}"
)
public interface TvMazeService {

    @GetMapping(path = "/{id}")
    TvMazeModel getShowById(@PathVariable int id);
    
}

