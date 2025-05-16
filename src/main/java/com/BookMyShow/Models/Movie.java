package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie extends BaseEntity{

    private String title;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int MovieId;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    @ManyToMany
    private List<Genre> genres;

    @Enumerated(EnumType.ORDINAL)
    @ManyToMany
    private List<Language> languages;

}
