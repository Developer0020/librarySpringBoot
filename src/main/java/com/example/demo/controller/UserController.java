package com.example.demo.controller;


import com.example.demo.service.BookService;
import com.example.demo.service.StudentBookService;
import com.example.demo.util.Component;
import com.example.demo.util.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentBookService studentBookService;
    @GetMapping("/bookList")
    private void bookList() {
        bookService.bookList();
    }
    @GetMapping("takeBook{id}")
    private void takeBook(@PathVariable Integer id) {
    }
    @GetMapping("/takenBook/{id}")
    private void takenBook(@PathVariable Integer id) {
        studentBookService.takenBook(id);
    }
    @GetMapping("/history/{id}")
    private void history(@PathVariable Integer id) {
        studentBookService.history(id);
    }
    private void orderBook() {
    }
}

