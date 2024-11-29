package ibrahim.GraphQL.service;

import ibrahim.GraphQL.model.TheUser;
import ibrahim.GraphQL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TheUser saveUser(TheUser theUser) {
        return userRepository.save(theUser);
    }

    public List<TheUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<TheUser> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
