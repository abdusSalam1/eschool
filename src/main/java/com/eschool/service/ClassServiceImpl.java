package com.eschool.service;

import com.eschool.domain.classInfo.StudentClass;
import com.eschool.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public void addClass(StudentClass studentClass) {
        this.classRepository.save(studentClass);
    }
}
