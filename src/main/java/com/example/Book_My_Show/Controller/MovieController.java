package com.example.Book_My_Show.Controller;


import com.example.Book_My_Show.Model.Movie;
import com.example.Book_My_Show.RequestDto.MovieRequestDto;
import com.example.Book_My_Show.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public String addMovie(@RequestBody MovieRequestDto movieRequestDto){
        return movieService.addMovie(movieRequestDto);
    }

    @GetMapping("/getMovieByName")
    public Movie getMovieByName(@RequestParam String movieName){
        return movieService.getMovieByName(movieName);
    }

}
