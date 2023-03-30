package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        sessionFactory.close();
        transaction.commit();
        session.close();
    }
    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);

        transaction.commit();
        session.close();
    }
    public List<Book> bookList() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Book> bookList = session.createQuery("from Book ", Book.class);

        transaction.commit();
        session.close();
        return bookList.getResultList();
    }
    public Book getBookById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();
        return session.find(Book.class, id);
    }
}
