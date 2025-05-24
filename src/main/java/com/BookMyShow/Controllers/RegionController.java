package com.BookMyShow.Controllers;

import com.BookMyShow.DTOs.RegionResponseDTO;
import com.BookMyShow.DTOs.ResponseStatus;
import com.BookMyShow.Models.Region;
import com.BookMyShow.Services.RegionService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RegionController
{
    @Autowired
    RegionService regionService;

    public RegionResponseDTO getAllRegions()
    {
        RegionResponseDTO regionResponseDTO = new RegionResponseDTO();
        try
        {
            List<Region> regions = regionService.getAllRegions();
            regionResponseDTO.setRegions(regions);
            regionResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return regionResponseDTO;
        }
        catch(Exception e)
        {
            regionResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            regionResponseDTO.setMessage("Failed to get regions");
            return regionResponseDTO;
        }
    }

}
