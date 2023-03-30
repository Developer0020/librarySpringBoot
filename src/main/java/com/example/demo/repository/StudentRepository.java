package com.example.demo.repository;


import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addStudent(StudentDTO studentDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(studentDTO);
        transaction.commit();
        sessionFactory.close();
        session.close();
    }

    public List<Student> studentList() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Student> student = session.createQuery("from Student ", Student.class);

        transaction.commit();
        session.close();
        return student.getResultList();

    }

    public Student getStudent(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.find(Student.class, id);
        transaction.commit();
        session.close();
        return student;
    }

    public void deleteStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);
        transaction.commit();
        session.close();
    }
}
