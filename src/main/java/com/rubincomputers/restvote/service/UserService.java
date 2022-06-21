package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.model.User;
import com.rubincomputers.restvote.exception.NotFoundException;
import com.rubincomputers.restvote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService extends AbstractService<User>{

    @Autowired
    private UserRepository repository;

    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");


    @Override
    public List<User> getAll() {
        return super.getAll(SORT_NAME_EMAIL);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.getByEmail(email).orElseThrow(() -> new NotFoundException(entity + " not found with email=" + email));
    }


}
