package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Region extends BaseEntity{

    private String regionName;
    private int regionCode;

    @OneToMany
    private List<Theater> theaters;

}
