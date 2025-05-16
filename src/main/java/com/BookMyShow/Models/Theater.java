package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theater extends  BaseEntity{

    private String theaterName;
    private String theaterAddress;

    @Enumerated(EnumType.ORDINAL)
    private TheaterStatus theaterStatus;

    @ManyToOne
    private Region theaterRegion;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screens;
}
