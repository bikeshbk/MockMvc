package com.personal.restApi.restTestByRestAssured.repository;

import com.personal.restApi.restTestByRestAssured.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    StudentModel findOneById(Long id);
}
