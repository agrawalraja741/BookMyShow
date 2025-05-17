package com.BookMyShow.DTOs;

import lombok.Data;

@Data
public class BookingResponseDTO {

    private int bookingId;
    private String message;
    private ResponseStatus responseStatus;
}
