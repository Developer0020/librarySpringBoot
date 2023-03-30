package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void bookList() {
        if (bookRepository.bookList()==null){
            System.err.println("kitob yo'q mazgi !!!");
            return;
        }
        bookRepository.bookList().stream().forEach(System.out::println);
    }
    public void addBook(BookDTO bookDTO) {
       Book bookEntity=new Book();
       bookEntity.setTitle(bookDTO.getTitle());
       bookEntity.setAuthor(bookDTO.getAuthor());
       bookEntity.setPublishYear(LocalDate.now());
        bookRepository.addBook(bookEntity);
    }
    public void deleteBook(Integer id, boolean visible) {
        if (bookRepository.getBookById(id) == null) {
            System.err.println("bunday idLi kitob mavju emas !");
        } else {
            Book book =bookRepository.getBookById(id);
            book.setVisible(visible);
            bookRepository.updateBook(book);
        }
    }
}
