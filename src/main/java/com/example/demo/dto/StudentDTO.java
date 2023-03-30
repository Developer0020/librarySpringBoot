package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private LocalDate createdDate;
    private boolean visible;
}
