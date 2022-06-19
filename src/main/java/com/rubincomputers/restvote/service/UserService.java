package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.entity.User;
import com.rubincomputers.restvote.exception.NotFoundException;
import com.rubincomputers.restvote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);

    }

    public User get(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User Not found with " + id));
    }


    public void delete(int id) {
        if (repository.deleteById(id) == 0) {
            throw new NotFoundException("User not found id=" + id);
        }
    }


    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");
    public List<User> getAll() {
        return repository.findAll((SORT_NAME_EMAIL));
    }
}
