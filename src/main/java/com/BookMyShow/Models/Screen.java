package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseEntity {

    private String name;
    private int screenId;

    @Enumerated(EnumType.ORDINAL)
    private Screen_Show_Type screenType ;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    private ScreenStatus screenStatus;


}
