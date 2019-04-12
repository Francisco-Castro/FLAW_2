package zipcode.group.walf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> index() {
        return userRepository.findAll();
    }

    public User show(Long id) {
        return userRepository.findById(id).get();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User newUserData) {
        User originalUser = userRepository.findById(id).get();
        originalUser.setUsername(newUserData.getUsername());
        return userRepository.save(originalUser);
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
