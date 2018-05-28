package com.personal.restApi.restTestByRestAssured.service.impl;

import com.personal.restApi.restTestByRestAssured.model.StudentModel;
import com.personal.restApi.restTestByRestAssured.repository.StudentRepository;
import com.personal.restApi.restTestByRestAssured.service.StudentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public StudentModel save(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    @Override
    public StudentModel findOneById(Long id) {
        return studentRepository.findOneById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
