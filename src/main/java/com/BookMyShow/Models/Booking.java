package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Booking extends BaseEntity{

    private String bookingId;
    private LocalDateTime BookingDate;
    private BookingStatus bookingStatus;

    @OneToOne
    private Payment payment;

    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User user;

}
