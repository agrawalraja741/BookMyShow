package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ShowSeatType extends BaseEntity{

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int price;

    @OneToMany(mappedBy = "showSeatType")
    private List<ShowSeat> showSeat;
}
