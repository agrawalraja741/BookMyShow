package com.BookMyShow.Controllers;

import com.BookMyShow.DTOs.ResponseStatus;
import com.BookMyShow.DTOs.UserSignupRequestDTO;
import com.BookMyShow.DTOs.UserSignupResponseDTO;
import com.BookMyShow.Models.User;
import com.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public UserSignupResponseDTO signupUser(UserSignupRequestDTO userSignupRequestDTO)
    {
        UserSignupResponseDTO userSignupResponseDTO = new UserSignupResponseDTO();

        try
        {
            String username = userSignupRequestDTO.getUsername();
            String email = userSignupRequestDTO.getEmail();
            String password = userSignupRequestDTO.getPassword();
            String MobileNumber = userSignupRequestDTO.getMobileNumber();

            int userId = userService.signupUser(username, email, password, MobileNumber);

            if(userId > 0)
            {
                userSignupResponseDTO.setUserId(userId);
                userSignupResponseDTO.setMessage("User Signup Successful");
                userSignupResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            }
            else
            {
                throw new RuntimeException("User not signed up. Please try again.");
            }

            return userSignupResponseDTO;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            userSignupResponseDTO.setMessage(e.getMessage());
            userSignupResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            return userSignupResponseDTO;
        }
    }

    public UserSignupResponseDTO loginUser(UserSignupRequestDTO userSignupRequestDTO)
    {
        UserSignupResponseDTO userSignupResponseDTO = new UserSignupResponseDTO();

        try
        {
            String email = userSignupRequestDTO.getEmail();
            String password = userSignupRequestDTO.getPassword();

            User loggedInUser = userService.loginUser( email, password);

            if(loggedInUser != null )
            {
                userSignupResponseDTO.setUserId(loggedInUser.getId());
                userSignupResponseDTO.setMessage("User login Successful");
                userSignupResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            }
            else
            {
               throw new RuntimeException("Login Failed");
            }

            return userSignupResponseDTO;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            userSignupResponseDTO.setMessage(e.getMessage());
            userSignupResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            return userSignupResponseDTO;
        }
    }
}
