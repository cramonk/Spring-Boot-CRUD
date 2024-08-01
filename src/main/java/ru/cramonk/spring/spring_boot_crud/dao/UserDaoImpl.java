package ru.cramonk.spring.spring_boot_crud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.cramonk.spring.spring_boot_crud.entity.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private  EntityManager em;


    @Override
    public List<User> showAll() {
        Query query = em.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void addOrUpdateUser(User user) {
        em.merge(user);
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        Query query = em.createQuery("delete from User where id = :userID");
        query.setParameter("userID", id);
        query.executeUpdate();
    }
}
