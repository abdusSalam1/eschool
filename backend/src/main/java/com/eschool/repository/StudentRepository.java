package com.eschool.repository;

import com.eschool.domain.student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * Created by Abdus Salam on 8/24/2018.
 */
public interface StudentRepository extends MongoRepository<Student, UUID> {
}
