package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theater extends  BaseEntity{

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theaterId;

    private String theaterName;
    private String theaterAddress;

    @Enumerated(EnumType.ORDINAL)
    private TheaterStatus theaterStatus;

    @ManyToOne
    private Region theaterRegion;

    @OneToMany
    private List<Screen> screens;
}
