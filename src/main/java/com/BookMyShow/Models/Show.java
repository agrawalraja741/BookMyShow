package com.BookMyShow.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Show extends BaseEntity{

    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int showId;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    private Screen_Show_Type showType;

    @OneToMany
    private List<ShowSeat> showSeats;

    private ShowStatus showStatus;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToMany
    private List<Screen> screens;



}
