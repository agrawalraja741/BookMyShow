package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Booking extends BaseEntity{

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int BookingID;

    private LocalDateTime BookingDate;
    private BookingStatus bookingStatus;

    private Payment payment;

    @OneToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User user;

}
