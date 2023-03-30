package com.example.demo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name ="book" )
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publishYear")
    private LocalDate publishYear;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "visible")
    private boolean visible = true;

}
//id,title,author, publishYear, amount, visible