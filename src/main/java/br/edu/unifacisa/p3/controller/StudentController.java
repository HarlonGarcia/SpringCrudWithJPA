package br.edu.unifacisa.p3.controller;

import br.edu.unifacisa.p3.exceptions.NoContentException;
import br.edu.unifacisa.p3.exceptions.UserAlreadyExistsException;
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

    @GetMapping("/{rdm}")
    public ResponseEntity<Student> findStudentById(@PathVariable("rdm") int rdm) {
        try {
            return new ResponseEntity<Student>(studentService.findStudentById(rdm), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<List<Student>>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @DeleteMapping("/{rdm}")
    public ResponseEntity<String> deleteStudent(@PathVariable("rdm") int rdm) {
        try {
            studentService.deleteStudent(rdm);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoContentException e) {
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
        } catch (NoContentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}