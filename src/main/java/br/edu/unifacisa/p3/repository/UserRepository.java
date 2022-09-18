package br.edu.unifacisa.p3.repository;

import br.edu.unifacisa.p3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(int id);
    public List<User> findAll();
}
