package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.RequestDto.TicketRequestDto;
import com.example.Book_My_Show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticker")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody TicketRequestDto bookTicketRequestDto){
        try {
            return ticketService.bookTicket(bookTicketRequestDto);
        }catch (Exception e){
            return "Requested Seats not available";
        }
}
