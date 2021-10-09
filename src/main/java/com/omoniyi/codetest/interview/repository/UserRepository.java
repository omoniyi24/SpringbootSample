package com.omoniyi.codetest.interview.repository;

import com.omoniyi.codetest.interview.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author OMONIYI ILESANMI
 */
public interface UserRepository extends MongoRepository<User,String> {
}
