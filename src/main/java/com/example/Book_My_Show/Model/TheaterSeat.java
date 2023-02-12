package com.example.Book_My_Show.Model;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theater_seats")
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "seatNo",nullable = false)
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private String seatType;

    private int rate;

    @ManyToOne
    @JoinColumn
    private Theater theater ;

    public SeatType getSeatType() {
        return SeatType.valueOf(seatType);
    }

    public TheaterSeat(String seatNo, SeatType seatType, int rate){
        this.seatNo = seatNo;
        this.seatType = String.valueOf(seatType);
        this.rate = rate;

    }

}
