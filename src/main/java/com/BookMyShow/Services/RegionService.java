package com.BookMyShow.Services;

import com.BookMyShow.Models.Region;
import com.BookMyShow.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    public List<Region> getAllRegions()
    {
        Optional<List<Region>> optionalRegions = regionRepository.getAllByIdGreaterThan(0);

        if(optionalRegions.isEmpty())
        {
            throw new RuntimeException("No regions found");
        }
        return optionalRegions.get();
    }
}
