package com.BookMyShow.Models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ShowSeat extends BaseEntity{

    @ManyToMany
    private List<ShowSeatType> showSeatType;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus showSeatStatus;

    private LocalDateTime blockedAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private Show show;

}
