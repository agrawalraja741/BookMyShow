package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="BMS_USER")
public class User extends BaseEntity{

    private String username;
    private String password;
    private String MobileNumber;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
}
