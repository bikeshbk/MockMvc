package com.personal.restApi.restTestByRestAssured.service;

import com.personal.restApi.restTestByRestAssured.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<StudentModel> findAll();
    StudentModel save(StudentModel studentModel);
    void delete(Long id);
    StudentModel findOneById(Long id);
}
