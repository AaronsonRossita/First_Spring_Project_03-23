package com.First_Spring_Project_0323.tvMaze;

import com.First_Spring_Project_0323.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tv_maze")
public class TvMazeController {

    @Autowired
    private TvMazeService tvMazeService;

    @GetMapping
    public TvMazeModel getShowById(@RequestParam int id){
        return tvMazeService.getShowById(id);
    }

}
