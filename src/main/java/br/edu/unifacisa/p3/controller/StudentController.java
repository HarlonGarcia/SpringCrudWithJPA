package br.edu.unifacisa.p3.controller;

import br.edu.unifacisa.p3.model.Student;
import br.edu.unifacisa.p3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<Student>(studentService.findStudentById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<List<Student>>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
