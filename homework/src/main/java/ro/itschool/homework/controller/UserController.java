package ro.itschool.homework.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.homework.model.User;
import ro.itschool.homework.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping
    public List<User>getAllUsers(){
        return UserService.getUSERS();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User userById = userService.getUserById(id);
        if(userById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userById);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User added successfully";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable int id, @RequestBody User user){
        User existingUser = userService.getUserById(id);
        if(existingUser == null){
            return ResponseEntity.notFound().build();
        }
        userService.updateUser( user, existingUser);
        return ResponseEntity.ok(existingUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> replaceUser(@PathVariable int id, @RequestBody User user){
        User existingUser = userService.getUserById(id);
        if(existingUser == null){
            return ResponseEntity.notFound().build();
        }
        userService.replaceUser( user, existingUser);
        return ResponseEntity.ok(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }

}
