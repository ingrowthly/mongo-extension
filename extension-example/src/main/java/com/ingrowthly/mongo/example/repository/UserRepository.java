package com.ingrowthly.mongo.example.repository;

import com.ingrowthly.mongo.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @since 2022/11/22
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>, UserCustom {
}
