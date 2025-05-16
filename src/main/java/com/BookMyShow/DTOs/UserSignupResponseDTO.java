package com.BookMyShow.DTOs;

import com.BookMyShow.Models.User;
import lombok.Data;

@Data
public class UserSignupResponseDTO {

    private int userId;
    private String message;
    private ResponseStatus responseStatus;
}
