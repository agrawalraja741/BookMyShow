package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ShowSeatType extends BaseEntity{

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int price;

    @ManyToMany(mappedBy = "showSeatType")
    private List<ShowSeat> showSeat;
}
