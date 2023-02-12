package com.example.Book_My_Show.RequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TheaterSeatDto {

    @Column(columnDefinition = "seatNo",nullable = false)
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private String seatType;

    private int rate;

}
