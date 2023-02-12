package com.example.Book_My_Show.RequestDto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TicketRequestDto {

    private List<String> requestedSeats;

    private int showId;

    private int userId;

}
