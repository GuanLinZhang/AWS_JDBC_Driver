package com.guanlinz.AWS_JDBC_Driver.Controller;

import com.guanlinz.AWS_JDBC_Driver.Dao.UserRepository;
import com.guanlinz.AWS_JDBC_Driver.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        try {
            var resultSet = new ArrayList<>();
            userRepository.findAll().iterator().forEachRemaining(resultSet::add);
            log.info("result: " + resultSet);
            return ResponseEntity.ok(resultSet);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Arrays.toString(e.getStackTrace()));
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody User newUser) {
        try {
            var result = userRepository.save(newUser);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
