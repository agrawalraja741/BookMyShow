package com.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie extends BaseEntity{

    private String title;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Genre> genres;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;

}
