package com.company.LibraryApplicationWithSpringMVC.repository;

import com.company.LibraryApplicationWithSpringMVC.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll(String name, String surname) {
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name";
        }

        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }

        Query query = entityManager.createQuery(jpql);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }

        return query.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        String jpql = "select u from User u where u.email=:email ";

        Query query = entityManager.createQuery(jpql);
        query.setParameter("email", email);

        return (User) query.getSingleResult();
    }
}
