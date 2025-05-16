package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Seat extends  BaseEntity {

    private int seatNo;
    private SeatType seatType;
    private SeatStatus seatStatus;

    @ManyToOne
    private Screen screen;
}
