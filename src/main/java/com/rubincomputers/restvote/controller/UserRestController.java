package com.rubincomputers.restvote.controller;

import com.rubincomputers.restvote.entity.User;
import com.rubincomputers.restvote.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.rubincomputers.restvote.util.ValidationUtil.checkNew;

@RestController
public class UserRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;


    @PostMapping("/users")
    public User create(@RequestBody User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

}
