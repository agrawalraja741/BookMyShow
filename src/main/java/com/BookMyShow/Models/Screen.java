package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseEntity {

    private String name;
    private int screenId;

    @Enumerated(EnumType.ORDINAL)
    private Screen_Show_Type screenType ;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    private ScreenStatus screenStatus;

    @ManyToOne
    private Theater theater;

    @ManyToMany
    private List<Show> show;

}
