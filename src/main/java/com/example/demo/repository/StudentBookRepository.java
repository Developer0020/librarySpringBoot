package com.example.demo.repository;


import com.example.demo.entity.StudentBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentBookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void takeBook(StudentBook studentBook) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(studentBook);

        transaction.commit();
        session.close();
    }

    public StudentBook getstudentBook(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StudentBook studentBook = session.find(StudentBook.class,id);

        transaction.commit();
        session.close();
        return studentBook;
    }

    public List<StudentBook> studentBookListByStudentId(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<StudentBook> studentBook= session.createQuery("from StudentBook where id=id ", StudentBook.class);

        transaction.commit();
        session.close();
        return studentBook.getResultList();
    }

    public void update(StudentBook studentBook){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(studentBook);
        transaction.commit();
        session.close();
    }
}
