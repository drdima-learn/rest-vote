package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.exception.NotFoundException;
import com.rubincomputers.restvote.model.Dish;
import com.rubincomputers.restvote.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class DishService extends AbstractService<Dish>{

    @Autowired
    private DishRepository repository;








//    public User create(User user) {
//        Assert.notNull(user, "user must not be null");
//        Assert.isTrue(user.isNew(), "user id must be null");
//        return repository.save(user);
//
//    }
//
//
//
//
//    public void delete(int id) {
//        if (repository.delete(id) == 0) {
//            throw new NotFoundException("User not found id=" + id);
//        }
//    }
//
//    public void deleteAll(){
//        repository.deleteAll();
//    }
//
//
//    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");
//
//    public List<User> getAll() {
//        return repository.findAll((SORT_NAME_EMAIL));
//    }
//
//    public User getByEmail(String email) {
//        Assert.notNull(email, "email must not be null");
//        return repository.getByEmail(email).orElseThrow(() -> new NotFoundException("User not found with email=" + email));
//    }
//
//    @Transactional
//    public void update(User user) {
//        Assert.notNull(user, "user must not be null");
//        Assert.isTrue(!user.isNew(), "user id must not be null");
//        User updated = repository.save(user);
//        if (updated.id() != user.id()) {
//            throw new NotFoundException("user with wrong id");
//        }
//    }
}
