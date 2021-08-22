package pl.indexpz.aws_springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.indexpz.aws_springboot.model.User;
import pl.indexpz.aws_springboot.repository.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found"));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User userToUpdate, @PathVariable(value = "id") Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id: " + id + " not found"));
        user.setFirstName(userToUpdate.getFirstName());
        user.setLastName(userToUpdate.getLastName());
        user.setEmail(userToUpdate.getEmail());
        return this.userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id: " + id + " not found"));
        this.userRepository.delete(user);
        return ResponseEntity.ok().build();
    }


}
