package com.guanlinz.AWS_JDBC_Driver.Controller;

import com.guanlinz.AWS_JDBC_Driver.Entity.User;
import com.guanlinz.AWS_JDBC_Driver.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Arrays;

@RestController
@RequestMapping("/users")
@Slf4j
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(userService.getUsers());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Arrays.toString(e.getStackTrace()));
        }
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> save(@RequestBody User newUser) {
        try {
            return ResponseEntity.ok(userService.save(newUser));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Arrays.toString(e.getStackTrace()));
        }
    }

    @DeleteMapping("/reset")
    @Transactional
    public ResponseEntity<?> reset() {
        try {
            userService.reset();
            return ResponseEntity.ok("delete all");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Arrays.toString(e.getStackTrace()));
        }
    }
}
