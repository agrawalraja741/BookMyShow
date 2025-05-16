package com.BookMyShow.Services;

import com.BookMyShow.DTOs.UserSignupRequestDTO;
import com.BookMyShow.DTOs.UserSignupResponseDTO;
import com.BookMyShow.Models.User;
import com.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int signupUser(String username , String email, String password , String mobileNumber)
    {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent())
        {
            throw new RuntimeException("User already exists");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setUsername(username);
        user.setMobileNumber(mobileNumber);

        User savedUser = userRepository.save(user);
        if(savedUser != null)
        {
            return savedUser.getId();
        }

        return -1;
    }

    public User loginUser( String email, String password )
    {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty())
        {
            throw new RuntimeException("User does not exist");
        }

        User savedUser = optionalUser.get();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword()))
        {
            return savedUser;
        }
        else
        {
            throw new RuntimeException("Incorrect password");
        }
    }
}
