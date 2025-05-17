package com.BookMyShow.DTOs;

import com.BookMyShow.Models.ShowSeat;
import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDTO {

    private List<Integer> showSeatsIds;
    private int showId;
    private int userId;

}
