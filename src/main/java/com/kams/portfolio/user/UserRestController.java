package com.kams.portfolio.user;
 
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET → fetch all users as JSON
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST → create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
