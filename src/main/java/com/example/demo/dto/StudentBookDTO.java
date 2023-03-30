package com.example.demo.dto;

import com.example.demo.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentBookDTO {
    private Integer id;
    private Integer student_id;
    private Integer book_id;
    private LocalDate createdDate;
    private Status status;
    private LocalDate returnedDate;
    private String duration;
}
