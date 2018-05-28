package com.personal.restApi.restTestByRestAssured.resource;

import com.personal.restApi.restTestByRestAssured.model.StudentModel;
import com.personal.restApi.restTestByRestAssured.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public ResponseEntity<List<StudentModel>> getStudents() {
        List<StudentModel> studentModels = studentService.findAll();
        return ResponseEntity.ok().body(studentModels);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<?> GetStudent(@PathVariable Long id) {
        return ResponseEntity.ok().body(studentService.findOneById(id));
    }

    @PostMapping("student")
    public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel studentModel) throws URISyntaxException {
        if (studentModel.getId() != null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.created(new URI("/api/student")).body(studentService.save(studentModel));
    }

    @PutMapping("student")
    public ResponseEntity<StudentModel> updateStudent (@RequestBody StudentModel studentModel) throws URISyntaxException{
        if (studentModel.getId() == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.created(new URI("api/student")).body(studentService.save(studentModel));
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
