package com.eschool.repository;

import com.eschool.domain.classInfo.StudentClass;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StudentClassRepository extends MongoRepository<StudentClass, UUID> {
}
