package br.edu.unifacisa.p3.service;

import br.edu.unifacisa.p3.model.User;
import br.edu.unifacisa.p3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserById(int id) throws Exception {
        User user = userRepository.findById(id);

        if (user != null) {
            return userRepository.findById(id);
        }
        throw new Exception();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User userWithChanges) throws Exception {
        User user = userRepository.findById(userWithChanges.getId());

        if (user != null) {
            user.setName(userWithChanges.getName());
            user.setUsername(userWithChanges.getUsername());
            user.setPassword(userWithChanges.getPassword());
            return user;
        }
        throw new Exception();
    }
}
