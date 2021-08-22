package pl.indexpz.aws_springboot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.indexpz.aws_springboot.exception.ResourceNotFoundException;
import pl.indexpz.aws_springboot.model.User;
import pl.indexpz.aws_springboot.repository.UserRepository;
import pl.indexpz.aws_springboot.service.UserService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void
    updateUser(User userToUpdate) {
        User user = getUserById(userToUpdate.getId());
        user.setFirstName(userToUpdate.getFirstName());
        user.setLastName(userToUpdate.getLastName());
        user.setEmail(userToUpdate.getEmail());
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = getUserById(id);
       userRepository.delete(user);
    }
}
