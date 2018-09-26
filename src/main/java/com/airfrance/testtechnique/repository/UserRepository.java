package com.airfrance.testtechnique.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.airfrance.testtechnique.entity.User;

/**
 * 
 * @author hichem.bouhlel
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
