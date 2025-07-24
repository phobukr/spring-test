package com.example.springtest.models;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
public class BookRead {
    private Long id;
    private String title;
    private String authorName;
    private Integer authorId;
    private String genre;
    private LocalDate publicationDate;
}