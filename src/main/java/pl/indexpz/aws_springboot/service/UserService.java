package pl.indexpz.aws_springboot.service;

import pl.indexpz.aws_springboot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getUserById(Long id);

    User addUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}
