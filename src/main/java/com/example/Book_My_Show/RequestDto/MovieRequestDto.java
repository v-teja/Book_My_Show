package com.example.Book_My_Show.RequestDto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequestDto {


    @Column(nullable = false,unique = true)
    private String name;

    private int duration;

    private Date releaseDate;


}
