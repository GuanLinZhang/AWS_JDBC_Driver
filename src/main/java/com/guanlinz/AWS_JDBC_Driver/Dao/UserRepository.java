package com.guanlinz.AWS_JDBC_Driver.Dao;

import com.guanlinz.AWS_JDBC_Driver.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
