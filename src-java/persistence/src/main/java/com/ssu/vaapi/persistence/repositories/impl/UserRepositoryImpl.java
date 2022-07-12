package com.ssu.vaapi.persistence.repositories.impl;

import com.ssu.vaapi.persistence.entities.User;
import com.ssu.vaapi.persistence.repositories.UserRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Optional;

public class UserRepositoryImpl extends GenericRepository<User> implements UserRepository {

    @Override
    public Optional<User> findById(Long userId) {
        throw new NotImplementedException();
    }
}
