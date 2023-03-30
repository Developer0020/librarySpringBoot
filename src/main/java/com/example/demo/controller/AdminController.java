package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.BookService;
import com.example.demo.service.StudentBookService;
import com.example.demo.service.UserService;
import com.example.demo.util.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/AdminController")
public class AdminController {
    @Autowired
    private Scan scanner;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentBookService studentBookService;

//    public void start() {
//        boolean b = true;
//        while (b) {
//            switch (menu()) {
//                case 1 -> bookList();
//                case 2 -> addBook();
//                case 3 -> deleteBook();
//                case 4 -> studentList();
//                case 5 -> addStudent();
//                case 6 -> deleteStudent();
//                case 7 -> studentTakenBook();
//                case 8 -> bookTakenHistory();
//                case 0 -> b = false;
//                default -> b = false;
//            }
//        }
//    }
//    private Integer menu() {
//        System.out.println("--- Admin Menu ---");
//        System.out.println("1.Book List :");
//        System.out.println("2.Add Book :");
//        System.out.println("3.Delete Book :");
//        System.out.println("4.Student List :");
//        System.out.println("5.Add Student :");
//        System.out.println("6.Delete Student :");
//        System.out.println("7.Student Taken Book :");
//        System.out.println("8.Book Taken History :");
//        System.out.println("0.Exit :");
//        System.out.print("Enter action :");
//        return scanner.intScan().nextInt();
//    }

    @GetMapping(value = "/bookList")
    private void bookList() {
        bookService.bookList();
    }
    @PostMapping(value = "/addBook")
    private void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }
    @PutMapping ("/deleteBook/{id}")
    private void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id, false);
    }
    @GetMapping("/studentList")
    private void studentList() {
        userService.studentList();
    }
    @PostMapping("/addStudent")
    private void addStudent(@RequestBody StudentDTO studentDTO) {
        userService.addStudent(studentDTO);
    }
    @PutMapping("/deleteStudent/{id}")
    private void deleteStudent(@PathVariable Integer id) {
        userService.deleteStudent(id,false);
    }
    @GetMapping("/studentTakenBook/{id}")
    private void studentTakenBook(@PathVariable Integer id) {
        studentBookService.takenBook(id);
    }
    @GetMapping("/bookTakenHistory/{id}")
    private void bookTakenHistory(@PathVariable Integer id) {
        studentBookService.bookTakenHistory(id);
    }
}
