package com.personal.restApi.restTestByRestAssured;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.restApi.restTestByRestAssured.model.StudentModel;
import com.personal.restApi.restTestByRestAssured.repository.StudentRepository;
import com.personal.restApi.restTestByRestAssured.resource.StudentResource;
import com.personal.restApi.restTestByRestAssured.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class StudentTest {

    private StudentResource studentResource;
    private StudentModel studentModelPost, studentModelPut;

    @Before
    public void setupStudentModelPost() {
        studentModelPost = new StudentModel("bikesh", "patan", "9948787");
    }

    @Before
    public void setupStudentModelPut() {
        studentModelPut = new StudentModel(1l,"Hari Krishna", "patan", "9948787");
    }


    @Before
    public void setup() {
        studentResource = new StudentResource(new StudentServiceImpl(new StudentRepository() {
            @Override
            public StudentModel findOneById(Long id) {
                return new StudentModel();
            }

            @Override
            public List<StudentModel> findAll() {
                return null;
            }

            @Override
            public List<StudentModel> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<StudentModel> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends StudentModel> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends StudentModel> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<StudentModel> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public StudentModel getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends StudentModel> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends StudentModel> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<StudentModel> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends StudentModel> S save(S s) {
                return null;
            }

            @Override
            public Optional<StudentModel> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(StudentModel studentModel) {

            }

            @Override
            public void deleteAll(Iterable<? extends StudentModel> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends StudentModel> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends StudentModel> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends StudentModel> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends StudentModel> boolean exists(Example<S> example) {
                return false;
            }
        }));
    }

    @Test
    public void getStudentTest() throws Exception {
        MockMvcBuilders.standaloneSetup(studentResource).build()
                .perform(get("/api/student/{id}", 2))
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentsTest() throws Exception{
        MockMvcBuilders.standaloneSetup(studentResource).build()
                .perform(get("/api/students"))
                .andExpect(status().isOk());

    }

    private static String asJsonString(final StudentModel sm) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(sm);
    }

    @Test
    public void postStudentTest() throws Exception {
        MockMvcBuilders.standaloneSetup(studentResource).build()
                .perform(post("/api/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(studentModelPost)))
                .andExpect(status().isCreated());

    }

    @Test
    public void putStudentTest() throws Exception {
        MockMvcBuilders.standaloneSetup(studentResource).build()
                .perform(put("/api/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(studentModelPut)))
                .andExpect(status().isCreated());

    }

    @Test
    public void deleteTest() throws Exception{
        MockMvcBuilders.standaloneSetup(studentResource).build()
                .perform(delete("/api/student/{id}", 1))
                .andExpect(status().isOk());
    }

}
