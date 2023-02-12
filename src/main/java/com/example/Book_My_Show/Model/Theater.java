package com.example.Book_My_Show.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String city;
    private String address;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> shows;

    @OneToMany(mappedBy ="theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList;



}
