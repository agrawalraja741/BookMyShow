package com.BookMyShow.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "bms_show")
public class Show extends BaseEntity{

    private String name;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    private Screen_Show_Type showType;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;

    private ShowStatus showStatus;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToMany
    private List<Screen> screens;

    @OneToMany(mappedBy = "show")
    private List<Booking> bookings;



}
