package com.ssu.vaapi.persistence.repositories;

import com.ssu.vaapi.persistence.entities.User;

import java.util.Optional;

public interface UserRepository extends Repository<User> {

    Optional<User> findById (Long userId);
}
