package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Model.*;
import com.example.Book_My_Show.Repository.MovieRepository;
import com.example.Book_My_Show.Repository.ShowRepository;
import com.example.Book_My_Show.Repository.ShowSeatRepository;
import com.example.Book_My_Show.Repository.TheaterRepository;
import com.example.Book_My_Show.RequestDto.ShowRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;
    @Autowired
    private SimpleJpaRepository simpleJpaRepository;

    public String addShow(ShowRequestDto showRequestDto) {

        //convert dto to entity
        Show show = Show.builder().showDate(showRequestDto.getShowDate()).showTime(showRequestDto.getShowTime()).
                multiplier(showRequestDto.getMultiplier()).build();

        //get movie from repo
        Movie movie = movieRepository.findByMovieName(showRequestDto.getMovieName());

        //get theater from repo
        Theater theater = theaterRepository.findById(showRequestDto.getTheaterId()).get();

        show.setMovie(movie);
        show.setTheater(theater);

        //bcz we are doing a bidirectional mapping :
        //Optional things :
//        List<ShowEntity> currentListOfShow = movieEntity.getListOfShows();
//        currentListOfShow.add(showEntity);
//        movieEntity.setListOfShows(currentListOfShow);
        movie.getShows().add(show);
        theater.getShows().add(show);
        //theaterRepository.save(theaterEntity);

        List<ShowSeat> showSeatList = createShowSeats(theater.getTheaterSeatList());

        show.setShowSeatList(showSeatList);

        //For each ShowSeat : we need to mark that to which show it belongs (foriegn key will be filled )
        for(ShowSeat showSeat:showSeatList){
            showSeat.setShow(show);
        }

        movieRepository.save(movie);
        theaterRepository.save(theater);
        //showRepository.save(showEntity); this doessnt need to be called bcz parent save function is being called.

        return "Show added Successfully";

    }

    private List<ShowSeat> createShowSeats(List<TheaterSeat> theaterSeatList) {

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat: theaterSeatList){

            ShowSeat showSeat = ShowSeat.builder().seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).build();
            showSeatList.add(showSeat);
        }

        showSeatRepository.saveAll(showSeatList);

        return showSeatList;
    }
}
