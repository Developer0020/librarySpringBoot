package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBook(Book book) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        factory.close();
        session.close();
    }

    public void updateBook(boolean visible, Integer id) {
        String sql = "update book set visible ='%s' where id='%s'";
        sql = String.format(sql, visible, id);
        int n = jdbcTemplate.update(sql);
        if (n > 0) {
            System.out.println("Success Deleted !!!");
        }
    }

    public void updateBook(String amount, Integer id) {
        String sql = "update book set amount ='%s' where id='%s'";
        sql = String.format(sql, amount, id);
        int n = jdbcTemplate.update(sql);
        if (n > 0) {
            System.out.println("Success !!! ");
        }
    }

    public List<Book> bookList() {
        List<Book> bookList = jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }

    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM book Where id =" + id;
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class));
        return book;
    }
}
