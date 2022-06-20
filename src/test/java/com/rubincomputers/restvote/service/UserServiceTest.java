package com.rubincomputers.restvote.service;

import com.rubincomputers.restvote.UserTestData;
import com.rubincomputers.restvote.model.Role;
import com.rubincomputers.restvote.model.User;
import com.rubincomputers.restvote.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.rubincomputers.restvote.UserTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
@ActiveProfiles("test")
//@Sql(scripts = "classpath:data.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest {
    @Autowired
    private UserService service;


    @Test
    public void get() {
        User user = service.get(USER_ID);
        USER_MATCHER.assertMatch(user, UserTestData.user);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getByEmail() {
        User user = service.getByEmail("admin@gmail.com");
        USER_MATCHER.assertMatch(user, admin);
    }

    @Test
    public void getByEmailNotFound() {
        assertThrows(NotFoundException.class, () -> service.getByEmail("notfound@gmail.com"));
    }

    @Test
    public void getAll() {
        List<User> all = service.getAll();
        USER_MATCHER.assertMatch(all, admin, guest, user);
    }

    @Test
    public void getAllEmptyList() {
        service.deleteAll();
        List<User> all = service.getAll();
        USER_MATCHER.assertMatch(all, List.of());
    }

    @Test
    public void create() {
        User created = service.create(getNew());
        int newId = created.id();
        User newUser = getNew();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
        USER_MATCHER.assertMatch(service.get(newId), newUser);
    }

    @Test
    public void createDuplicateEmail() {
        assertThrows(DataAccessException.class, () ->
                service.create(new User(null, "Duplicate", "user@yandex.ru", "newPass", Role.USER)));
    }

    @Test
    public void delete() {
        service.delete(USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER_ID));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    public void update() {
        User updated = getUpdated();
        service.update(updated);
        USER_MATCHER.assertMatch(service.get(USER_ID), getUpdated());
    }

    @Test
    public void updateNotFound() {
        User updated = getUpdated();
        updated.setId(NOT_FOUND);
        assertThrows(NotFoundException.class, () -> service.update(updated));
    }
}
