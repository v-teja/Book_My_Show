package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Model.Show;
import com.example.Book_My_Show.Model.ShowSeat;
import com.example.Book_My_Show.Model.User;
import com.example.Book_My_Show.Repository.ShowRepository;
import com.example.Book_My_Show.Repository.TicketRepository;
import com.example.Book_My_Show.Repository.UserRepository;
import com.example.Book_My_Show.RequestDto.TicketRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;
    public String bookTicket(TicketRequestDto bookTicketRequestDto) {

        List<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();

        Show show = showRepository.findById(bookTicketRequestDto.getShowId()).get();
        User user = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        //Get the showSeats from showEntity
        List<ShowSeat> showSeats = show.getShowSeatList();

        //Validate if I can allocate these seats to the requested by user.

    }
}
