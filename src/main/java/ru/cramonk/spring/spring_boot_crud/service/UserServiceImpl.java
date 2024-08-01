package ru.cramonk.spring.spring_boot_crud.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.cramonk.spring.spring_boot_crud.dao.UserDao;
import ru.cramonk.spring.spring_boot_crud.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> showAll() {
        return userDao.showAll();
    }

    @Override
    public void addOrUpdateUser(User user) {
        userDao.addOrUpdateUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

}
