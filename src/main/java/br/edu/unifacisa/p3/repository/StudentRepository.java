package br.edu.unifacisa.p3.repository;

import br.edu.unifacisa.p3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findById(int id);
    public List<Student> findAll();
}
