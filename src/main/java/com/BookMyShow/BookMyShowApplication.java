package com.BookMyShow;

import com.BookMyShow.Controllers.BookingController;
import com.BookMyShow.Controllers.RegionController;
import com.BookMyShow.Controllers.UserController;
import com.BookMyShow.DTOs.*;
import com.BookMyShow.Models.Region;
import com.BookMyShow.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController;

	@Autowired
	private BookingController bookingController;

	@Autowired
	private RegionController regionController;


	@Override
	public void run(String... args) throws Exception {

		UserSignupRequestDTO userSignupRequestDTO = new UserSignupRequestDTO();
		userSignupRequestDTO.setEmail("email@email.com");
		userSignupRequestDTO.setPassword("password1223");
		userSignupRequestDTO.setUsername("username1223");
		userSignupRequestDTO.setMobileNumber("1223");

		UserSignupResponseDTO userSignupResponseDTO = userController.signupUser(userSignupRequestDTO);

		if(userSignupResponseDTO != null)
		{
			if(userSignupResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS))
			{
				System.out.println(userSignupResponseDTO.getMessage() + " UserId :  " + userSignupResponseDTO.getUserId());
			}
			else
			{
				System.out.println(userSignupResponseDTO.getMessage() );
			}
		}

		userSignupRequestDTO.setPassword("password1223");
		UserSignupResponseDTO userSignupResponseDTOLogin = userController.loginUser(userSignupRequestDTO);

		if(userSignupResponseDTOLogin != null)
		{
			if(userSignupResponseDTOLogin.getResponseStatus().equals(ResponseStatus.SUCCESS))
			{
				System.out.println(userSignupResponseDTOLogin.getMessage() + " UserId :  " + userSignupResponseDTOLogin.getUserId());
			}
			else
			{
				System.out.println(userSignupResponseDTOLogin.getMessage());
			}
		}
		else
		{
			System.out.println("Please try again!");
		}


		RegionResponseDTO regionResponseDTO = regionController.getAllRegions();

		for(Region region : regionResponseDTO.getRegions())
		{
			System.out.println(region.getRegionName());
		}

		BookingRequestDTO bookingRequestDTO = new BookingRequestDTO();
		List<Integer> showSeatIds = new ArrayList<>();
		showSeatIds.add(1);
		showSeatIds.add(2);
		showSeatIds.add(3);
		showSeatIds.add(4);
		bookingRequestDTO.setShowSeatsIds(showSeatIds);
		bookingRequestDTO.setShowId(1);
		bookingRequestDTO.setUserId(1);

		BookingResponseDTO bookingResponseDTO = bookingController.bookTicket(bookingRequestDTO);

		if(bookingResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS))
		System.out.println(bookingResponseDTO.getMessage()+ " Booking Id :  " + bookingResponseDTO.getBookingId());
		else
			System.out.println(bookingResponseDTO.getMessage() );



		BookingRequestDTO bookingRequestDTO1 = new BookingRequestDTO();
		List<Integer> showSeatIds1 = new ArrayList<>();
		showSeatIds1.add(1);
		showSeatIds1.add(2);
		showSeatIds1.add(4);
		bookingRequestDTO1.setShowSeatsIds(showSeatIds1);
		bookingRequestDTO1.setShowId(1);
		bookingRequestDTO1.setUserId(1);

		BookingResponseDTO bookingResponseDTO1 = bookingController.bookTicket(bookingRequestDTO1);

		if(bookingResponseDTO1.getResponseStatus().equals(ResponseStatus.SUCCESS))
			System.out.println(bookingResponseDTO1.getMessage()+ " Booking Id :  " + bookingResponseDTO1.getBookingId());
		else
			System.out.println(bookingResponseDTO1.getMessage() );


		BookingRequestDTO bookingRequestDTO2 = new BookingRequestDTO();
		List<Integer> showSeatIds2 = new ArrayList<>();
		showSeatIds2.add(1);
		showSeatIds2.add(2);
		bookingRequestDTO2.setShowSeatsIds(showSeatIds2);
		bookingRequestDTO2.setShowId(1);
		bookingRequestDTO2.setUserId(1);

		BookingResponseDTO bookingResponseDTO2 = bookingController.bookTicket(bookingRequestDTO2);

		if(bookingResponseDTO2.getResponseStatus().equals(ResponseStatus.SUCCESS))
			System.out.println(bookingResponseDTO2.getMessage()+ " Booking Id :  " + bookingResponseDTO2.getBookingId());
		else
			System.out.println(bookingResponseDTO2.getMessage() );
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
