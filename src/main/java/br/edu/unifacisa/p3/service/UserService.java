package br.edu.unifacisa.p3.service;

import br.edu.unifacisa.p3.exceptions.NoContentException;
import br.edu.unifacisa.p3.exceptions.UserAlreadyExistsException;
import br.edu.unifacisa.p3.model.User;
import br.edu.unifacisa.p3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserById(int id) throws NoContentException {
        User user = userRepository.findById(id);

        if (user != null) {
            return user;
        }
        throw new NoContentException("There is no user with that id");
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) throws NoContentException {
        User user = userRepository.findById(id);

        if (user != null) {
            userRepository.delete(user);
            return;
        }
        throw new NoContentException("There is no user with that id");
    }

    public User updateUser(User userWithChanges) throws NoContentException {
        User user = userRepository.findById(userWithChanges.getId());

        if (user != null) {
            user.setName(userWithChanges.getName());
            user.setUsername(userWithChanges.getUsername());
            user.setPassword(userWithChanges.getPassword());
            userRepository.save(user);
            return user;
        }
        throw new NoContentException("There is no user with that id");
    }

    public User createUser(User newUser) throws UserAlreadyExistsException {
        User user = userRepository.findById(newUser.getId());

        if (user == null) {
            return userRepository.save(newUser);
        }
        throw new UserAlreadyExistsException();
    }
}
