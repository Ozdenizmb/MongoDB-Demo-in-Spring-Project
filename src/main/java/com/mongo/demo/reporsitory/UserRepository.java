package com.mongo.demo.reporsitory;

import com.mongo.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    Page<User> findAll(Pageable pageable);
    User findByUsername(String username);
    void deleteByUsername(String username);

}
