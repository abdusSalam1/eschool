package com.eschool.service;

import com.eschool.domain.student.Student;
import com.eschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Click Chain on 8/24/2018.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        if(studentRepository.findById(student.getId()).isPresent()){
            studentRepository.save(student);
        }
        else {
            throw new NoSuchElementException("No student exists");
        }
    }

    @Override
    public Student findByStudentId(UUID id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        else {
            throw new NoSuchElementException("No student exists");
        }
    }

    @Override
    public List<Student> findAllStudents() {
       return studentRepository.findAll();
    }
}
