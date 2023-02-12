package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Model.Theater;
import com.example.Book_My_Show.RequestDto.TheaterRequestDto;
import com.example.Book_My_Show.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterRequestDto theaterRequestDto){

        return theaterService.createTheater(theaterRequestDto);

    }

    @GetMapping("/getById")
    public Theater getTheaterById(@RequestParam Integer theaterId){
        return  theaterService.getTheaterById(theaterId);
    }

    @GetMapping("/getAll")
    public List<Theater> getAllTheaters(){
        return theaterService.getAllTheaters();
    }
}
