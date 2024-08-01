package ru.cramonk.spring.spring_boot_crud.service;



import ru.cramonk.spring.spring_boot_crud.entity.User;

import java.util.List;

public interface UserService {
    List<User> showAll();

    void addOrUpdateUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);
}
