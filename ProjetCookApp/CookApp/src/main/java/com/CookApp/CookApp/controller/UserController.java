package com.CookApp.CookApp.controller;

import com.CookApp.CookApp.bdd.User;
import com.CookApp.CookApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.creer(user);
    }

    @GetMapping("/read")
    public List<User> read() {
        return userService.lire();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.modifier(id, user);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id) {
        return userService.supprimer(id);
    }
}
