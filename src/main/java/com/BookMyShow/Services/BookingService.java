package com.BookMyShow.Services;

import com.BookMyShow.Models.*;
import com.BookMyShow.Repository.BookingRepository;
import com.BookMyShow.Repository.ShowRepository;
import com.BookMyShow.Repository.ShowSeatRepository;
import com.BookMyShow.Repository.UserRepository;
import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public Booking bookTicket(List<Integer> showSeatIds,int  showId, int userId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty())
        {
            throw new RuntimeException("User not found");
        }

        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty())
        {
            throw new RuntimeException("Show not found");
        }

        List<ShowSeat> showSeats = reserveSeats(showSeatIds, showId);


        int amount =0 ;

        for(ShowSeat showSeat : showSeats)
        {
            int price = showSeat.getShowSeatType().getPrice();
            amount += price;
        }

        Booking booking = new Booking();
        booking.setUser(optionalUser.get());
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setBookingDate(LocalDateTime.now());
        booking.setAmount(amount);
        booking.setShowSeats(showSeats);
        booking.setShow(optionalShow.get());

        return bookingRepository.save(booking);
    }

    @Transactional(isolation =  Isolation.SERIALIZABLE)
    protected List<ShowSeat> reserveSeats(List<Integer> showSeatIds , int showId)
    {
        //check seats available and block them
        for(int showSeatId : showSeatIds)
        {
            checkAvailability(showSeatId);
        }

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats)
        {
            if(showSeat.getShow().getId() == showId)
            {
                showSeat.setShowSeatStatus(SeatStatus.BLOCKED);
                showSeat.setBlockedAt(LocalDateTime.now());
            }
        }

        return showSeatRepository.saveAll(showSeats);


    }

    private void checkAvailability(int showSeatId)
    {
        Optional<ShowSeat> optionalShowSeat = showSeatRepository.findById(showSeatId);
        if(optionalShowSeat.isEmpty())
        {
            throw new RuntimeException("Invalid ShowSeat Details");
        }

        ShowSeat showSeatDtls = optionalShowSeat.get();

        System.out.println(showSeatDtls.getId()+ "  " + showSeatDtls.getShowSeatStatus() );

        if(showSeatDtls.getShowSeatStatus().equals(SeatStatus.BOOKED))
        {
            throw new RuntimeException("ShowSeat are not available");
        }

        if(showSeatDtls.getShowSeatStatus().equals(SeatStatus.BLOCKED))
        {
            Duration duration = Duration.between(LocalDateTime.now(), showSeatDtls.getBlockedAt());
            if(duration.toMinutes() < 10)
            {
                throw new RuntimeException("ShowSeat is blocked. Please try after sometime");
            }
        }
    }
}
