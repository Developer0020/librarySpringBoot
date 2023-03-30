package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "studentBook")
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "book_id")
    private Integer book_id;
    @Column(name = "createdDate")
    private LocalDate createdDate;
    @Column(name = "status")
    private Status status;
    @Column(name = "returnedDate")
    private LocalDate returnedDate;
    @Column(name = "duration")
    private String duration; // davomiyliki yani nechi kun unda bo'lishi

}
//id,student_id,book_id,createdDate,status(TAKEN,RETURNED),returnedDate,duration