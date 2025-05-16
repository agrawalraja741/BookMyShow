package com.BookMyShow.Models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class ShowSeat extends BaseEntity{

    private int showSeatNo;

    @Enumerated(EnumType.ORDINAL)
    private SeatType showSeatType;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus showSeatStatus;

    private LocalDate blockedAt;

    private User user;

}
