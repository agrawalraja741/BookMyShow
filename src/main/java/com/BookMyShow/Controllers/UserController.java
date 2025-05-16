package com.BookMyShow.Controllers;

import com.BookMyShow.DTOs.ResponseStatus;
import com.BookMyShow.DTOs.UserSignupRequestDTO;
import com.BookMyShow.DTOs.UserSignupResponseDTO;
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
                userSignupResponseDTO.setUserId(userId);
                userSignupResponseDTO.setMessage("User not signed up. Please try again.");
                userSignupResponseDTO.setResponseStatus(ResponseStatus.FAILURE);

            }

            return userSignupResponseDTO;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
