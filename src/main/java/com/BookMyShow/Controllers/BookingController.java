package com.BookMyShow.Controllers;

import com.BookMyShow.DTOs.BookingRequestDTO;
import com.BookMyShow.DTOs.BookingResponseDTO;
import com.BookMyShow.DTOs.ResponseStatus;
import com.BookMyShow.Models.Booking;
import com.BookMyShow.Models.ShowSeat;
import com.BookMyShow.Services.BookingService;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    public BookingResponseDTO bookTicket(BookingRequestDTO bookingRequestDTO)
    {
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        try
        {
            List<Integer> showSeatIds = bookingRequestDTO.getShowSeatsIds();
            int showId = bookingRequestDTO.getShowId();
            int userId = bookingRequestDTO.getUserId();

            Booking booking = bookingService.bookTicket(showSeatIds, showId, userId);

            if(booking != null)
            {
                bookingResponseDTO.setBookingId(booking.getId());
                bookingResponseDTO.setMessage("Booking Successful");
                bookingResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
                return bookingResponseDTO;
            }
            else
            {
                throw new RuntimeException("Booking Failed");
            }
        }
        catch (Exception e)
        {
            bookingResponseDTO.setMessage(e.getMessage());
            bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            return bookingResponseDTO;
        }


    }
}
