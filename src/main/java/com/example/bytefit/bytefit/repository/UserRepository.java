package com.example.bytefit.bytefit.repository;

import com.example.bytefit.bytefit.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {

    Users findByFirstName(String firstName);
    List<Users> findByLastName(String lastName);
    Users findByEmail(@Param("email") String email);
}
