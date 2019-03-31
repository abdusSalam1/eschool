package com.eschool.service;

import com.eschool.domain.student.Student;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Created by Abdus Salam on 8/24/2018.
 */
public interface StudentService {

    void addStudent(Student student);

    void updateStudent(Student student) throws NoSuchElementException;

    Student findByStudentId(UUID id);

    List<Student> findAllStudents();
}
