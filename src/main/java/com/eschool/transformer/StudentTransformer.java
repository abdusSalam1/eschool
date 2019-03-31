package com.eschool.transformer;

import com.eschool.domain.fee.FeeFrequency;
import com.eschool.domain.student.Student;
import com.eschool.model.StudentModel;
import com.eschool.model.parent.ParentModel;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class StudentTransformer {

    public Student transform(StudentModel studentModel) {
        List<ParentModel> parentModels = studentModel.getParents();

        return Student.builder()
                .name(studentModel.getName())
                .cnic(studentModel.getCnic())
                .enrollmentNumber(studentModel.getEnrolmentNumber())
                .parents(parentModels.stream().map(ParentModel::toParent).collect(Collectors.toList()))
                .feeFrequency(FeeFrequency.valueOf(studentModel.getFeeFrequency()))
                .active(true).build();
    }
}