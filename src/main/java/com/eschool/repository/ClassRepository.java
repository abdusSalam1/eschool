package com.eschool.repository;

import com.eschool.domain.classInfo.StudentClass;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ClassRepository extends MongoRepository<StudentClass, UUID> {
}
