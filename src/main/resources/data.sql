DELETE FROM USER_ROLES;
DELETE FROM USERS;
--ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

DELETE FROM RESTAURANTS;

INSERT INTO RESTAURANTS (NAME, ENABLED)
VALUES  ('rest1',true),
        ('rest2',true),
        ('rest3', false);


DELETE FROM DISHES;
INSERT INTO DISHES (NAME, DAY, PRICE, RESTAURANT_ID)
VALUES  ('dish1 - rest1',NOW(), 101, 1),
        ('dish2 - rest1',NOW(), 202, 1),
        ('dish3 - rest1',NOW(), 303, 1),
        ('dish4 - rest2',NOW(), 404, 2),
        ('dish5 - rest2',NOW(), 505, 2),
        ('dish6 - rest3',NOW(), 606, 3);






