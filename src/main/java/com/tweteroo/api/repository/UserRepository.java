package com.tweteroo.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.tweteroo.api.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
