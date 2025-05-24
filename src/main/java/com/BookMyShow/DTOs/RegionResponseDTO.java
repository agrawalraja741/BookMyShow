package com.BookMyShow.DTOs;

import com.BookMyShow.Models.Region;
import lombok.Data;

import java.util.List;

@Data
public class RegionResponseDTO {

    private List<Region> regions;
    private String message;
    private ResponseStatus responseStatus;
}
