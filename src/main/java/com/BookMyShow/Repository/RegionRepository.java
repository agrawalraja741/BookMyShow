package com.BookMyShow.Repository;

import com.BookMyShow.Models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    Optional<List<Region>> getAllByIdGreaterThan(int idIsGreaterThan);
}
