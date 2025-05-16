package com.BookMyShow.DTOs;

import lombok.Data;

@Data
public class UserSignupRequestDTO {

    private String username;
    private String email;
    private String password;
    private String mobileNumber;

}
