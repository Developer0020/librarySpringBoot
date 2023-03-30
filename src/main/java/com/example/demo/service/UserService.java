package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
public class UserService {
    @Autowired
    private StudentRepository studentRepository;
    public void addStudent(StudentDTO studentDTO) {
        if (studentDTO != null) {
            studentRepository.addStudent(studentDTO);
        } else {
            System.err.println("Nimadur xato ketdi !!!");
        }
    }
    public void studentList() {
        if (studentRepository.studentList() != null) {
            studentRepository.studentList().stream().forEach(System.out::println);
        } else {
            System.err.println("List bo'sh !!!");
        }
    }
    public Student getStudentById(Integer id) {
        return null;
    }
    public void deleteStudent(Integer id, boolean visible) {
        Student student =studentRepository.getStudent(id);
        student.setVisible(visible);
        studentRepository.deleteStudent(student);
    }

}
