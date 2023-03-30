package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentBook;
import com.example.demo.enums.Status;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentBookRepository;
import com.example.demo.util.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Service
public class StudentBookService {
    @Autowired
    private StudentBookRepository studentBookRepository;
    @Autowired
    private BookRepository bookRepository;
    public void takeBook(Integer id) {
        if (studentBookRepository.studentBookListByStudentId(id).size() > 6) {
            System.err.println("Mazgibek sizda 5 kitob bor ekan bittasini qaytaring oldin !!!");
        } else if (Integer.valueOf(bookRepository.getBookById(id).getAmount()) > 0) {
            StudentBook studentBook = new StudentBook();
            studentBook.setStatus(Status.TAKEN);
            studentBookRepository.takeBook(studentBook);
        } else {
            System.err.printf("Bu kitobdan qolmagan yoki id ni xato kiritdingiz !!! ");
        }
    }
    public void takenBook(Integer id) {
        studentBookRepository.studentBookListByStudentId(id).stream().filter
                (studentBook -> studentBook.getStatus().equals(Status.TAKEN)).forEach(System.out::println);
    }
//    public void returnBook(Integer id) {
//        if (studentBookRepository.getstudentBook(id) == null) {
//            System.err.printf("Not found Pages !!! ");
//        } else if (studentBookRepository.getstudentBook(id).getStatus().equals(Status.TAKEN)) {
//            LocalDate createdDate = studentBookRepository.getstudentBook(id).getCreatedDate();
//            LocalDate returnedDate = LocalDate.now();
//            long days = ChronoUnit.DAYS.between(createdDate, returnedDate);
//            studentBookRepository.(book_id, student_id, String.valueOf(days));
//        }
//    }
    public void history(Integer id) {
        studentBookRepository.studentBookListByStudentId(id).stream().forEach(System.out::println);
    }
    public void bookTakenHistory(Integer id) {
        studentBookRepository.studentBookListByStudentId(id).stream().forEach(System.out::println);
    }
}
