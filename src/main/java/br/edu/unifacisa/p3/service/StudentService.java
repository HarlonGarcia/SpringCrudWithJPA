package br.edu.unifacisa.p3.service;

import br.edu.unifacisa.p3.model.Student;
import br.edu.unifacisa.p3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student findStudentById(int id) throws Exception {
        Student student = studentRepository.findById(id);

        if (student != null) {
            return student;
        }
        throw new Exception();
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student studentWithChanges) throws Exception {
        Student student = studentRepository.findById(studentWithChanges.getId());

        if (student != null) {
            student.setName(studentWithChanges.getName());
            student.setUsername(studentWithChanges.getUsername());
            student.setPassword(studentWithChanges.getPassword());
            student.setRdm(studentWithChanges.getRdm());
            student.setCourse(studentWithChanges.getCourse());
            return student;
        }
        throw new Exception();
    }
}
