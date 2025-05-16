package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ShowSeatType extends BaseEntity{

    private SeatType seatType;
    private int price;
}
