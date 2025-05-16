package com.BookMyShow;

import com.BookMyShow.Controllers.UserController;
import com.BookMyShow.DTOs.ResponseStatus;
import com.BookMyShow.DTOs.UserSignupRequestDTO;
import com.BookMyShow.DTOs.UserSignupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController;

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

		userSignupRequestDTO.setPassword("password1231212");
		UserSignupResponseDTO userSignupResponseDTOLogin = userController.loginUser(userSignupRequestDTO);

		if(userSignupResponseDTO != null)
		{
			if(userSignupResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS))
			{
				System.out.println(userSignupResponseDTO.getMessage() + " UserId :  " + userSignupResponseDTO.getUserId());
			}
			else
			{
				System.out.println(userSignupResponseDTO.getMessage());
			}
		}
		else
		{
			System.out.println("Please try again!");
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
