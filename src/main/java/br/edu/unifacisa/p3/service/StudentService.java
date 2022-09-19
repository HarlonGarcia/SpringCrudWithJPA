package br.edu.unifacisa.p3.service;

import br.edu.unifacisa.p3.exceptions.NoContentException;
import br.edu.unifacisa.p3.exceptions.UserAlreadyExistsException;
import br.edu.unifacisa.p3.model.Student;
import br.edu.unifacisa.p3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student findStudentById(int rdm) throws NoContentException {
        Student student = studentRepository.findByRdm(rdm);

        if (student != null) {
            return student;
        }
        throw new NoContentException("There is no student with that rdm");
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(int rdm) throws NoContentException {
        Student student = studentRepository.findByRdm(rdm);

        if (student != null) {
            studentRepository.delete(student);
            return;
        }
        throw new NoContentException("There is no student with that rdm");
    }

    public Student updateStudent(Student studentWithChanges) throws NoContentException {
        Student student = studentRepository.findByRdm(studentWithChanges.getRdm());

        if (student != null) {
            student.setRdm(studentWithChanges.getRdm());
            student.setName(studentWithChanges.getName());
            student.setCourse(studentWithChanges.getCourse());
            studentRepository.save(student);
            return student;
        }
        throw new NoContentException("There is no student with that rdm");
    }

    public Student createStudent(Student newStudent) throws UserAlreadyExistsException {
        Student student = studentRepository.findByRdm(newStudent.getRdm());

        if (student == null) {
            return studentRepository.save(newStudent);
        }
        throw new UserAlreadyExistsException();

    }
}
