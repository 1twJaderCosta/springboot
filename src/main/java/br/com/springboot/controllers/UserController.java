package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") Long id) {
        return this.userRepository.findById(id);
    }

    @GetMapping("/")
    public List<User> get() {
        return this.userRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public List<User> get(@PathVariable("id") Long id) {
        return this.userRepository.findGreaterThan(id);
    }

    @PostMapping("/")
    public User post(@RequestBody User user){
        return this.userRepository.save(user);
    }
}
