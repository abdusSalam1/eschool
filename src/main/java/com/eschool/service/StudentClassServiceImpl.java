package com.eschool.service;

import com.eschool.domain.classInfo.StudentClass;
import com.eschool.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Override
    public void addClass(StudentClass studentClass) {
        this.studentClassRepository.save(studentClass);
    }
}
