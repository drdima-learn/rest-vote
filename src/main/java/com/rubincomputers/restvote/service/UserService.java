package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.entity.Role;
import com.rubincomputers.restvote.entity.User;
import com.rubincomputers.restvote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        user.setRoles(Set.of(Role.USER));
        return repository.save(user);

    }
}
