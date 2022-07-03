package com.guanlinz.AWS_JDBC_Driver;

import com.guanlinz.AWS_JDBC_Driver.Dao.UserRepository;
import com.guanlinz.AWS_JDBC_Driver.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        try {
           return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

   @Transactional
    public List<User> getUsers() {
        try {
            var resultSet = new ArrayList<User>();
            userRepository.findAll().iterator().forEachRemaining(resultSet::add);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Transactional
    public void reset() {
        try {
            userRepository.deleteAll();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
