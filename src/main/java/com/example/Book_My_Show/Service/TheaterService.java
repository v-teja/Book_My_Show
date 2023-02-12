package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Model.Theater;
import com.example.Book_My_Show.Model.TheaterSeat;
import com.example.Book_My_Show.Repository.TheaterRepository;
import com.example.Book_My_Show.Repository.TheaterSeatRepository;
import com.example.Book_My_Show.RequestDto.TheaterRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;
    public String createTheater(TheaterRequestDto theaterRequestDto) {

        Theater theater = Theater.builder().city(theaterRequestDto.getCity()).name(theaterRequestDto.getName()).
               address(theaterRequestDto.getAddress()).build();

        List<TheaterSeat> theaterSeatList = createTheaterSeats();

        theater.setTheaterSeatList(theaterSeatList);//bidirectional

        //For each theater Seat : we need to set the theaterEntity
        for(TheaterSeat theaterSeat : theaterSeatList){
            theaterSeat.setTheater(theater);
        }

        theaterRepository.save(theater);

        return "Theater added successfully";

    }

    private List<TheaterSeat> createTheaterSeats() {

        List<TheaterSeat> theaterSeatList  = new ArrayList<>();

        //        TheaterSeatEntity theaterSeat1 = new TheaterSeatEntity("1A", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat2 = new TheaterSeatEntity("1B", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat3 = new TheaterSeatEntity("1C", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat4 = new TheaterSeatEntity("1D", SeatType.CLASSIC,100);
//        TheaterSeatEntity theaterSeat5 = new TheaterSeatEntity("1E", SeatType.CLASSIC,100);

        //Optimize by adding loop

        for(int i=0;i<5;i++){

            char ch = (char)('A'+i);

            String seatNo  = "1"+ ch;
            TheaterSeat theaterSeat = new TheaterSeat(seatNo, SeatType.CLASSIC,100);
            theaterSeatList.add(theaterSeat);
        }
        for(int i=0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo  = "2"+ ch;
            TheaterSeat theaterSeat = new TheaterSeat(seatNo,SeatType.PLATINUM,200);
            theaterSeatList.add(theaterSeat);
        }

        theaterSeatRepository.saveAll(theaterSeatList);

        return theaterSeatList;
    }

    public Theater getTheaterById(Integer theaterId) {

        return theaterRepository.findById(theaterId).get();
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }
}
