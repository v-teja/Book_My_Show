package com.example.Book_My_Show.RequestDto;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class ShowSeatRequestDto {

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    private Date bookedAt;

}
