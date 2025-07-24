package com.example.springtest.models;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
public class BookRead {
    @Id
    private Long id;
    private String title;
    private String authorName; 
    private String genre;
    private LocalDate publicationDate;
}