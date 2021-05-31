package com.company.LibraryApplicationWithSpringMVC.repository;

import com.company.LibraryApplicationWithSpringMVC.models.Book;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findAllByParameters(String search) {
        String jpql = "select b from Book b";

        if (search != null && !search.isEmpty()) {
            jpql += " where name like CONCAT('%',:s,'%')" +
                    " or description like CONCAT('%',:s,'%')" +
                    " or author like CONCAT('%',:s,'%')" +
                    " or price like CONCAT('%',:s,'%')";
        }

        Query query = entityManager.createQuery(jpql);

        if (search != null && !search.isEmpty()) {
            query.setParameter("s", search);
        }

        return (List<Book>) query.getResultList();
    }

    @Override
    public List<Book> getBooks(String name) {
        String jpql = "select b from Book b where 1=1 ";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and b.name=:name";
        }
        Query query = entityManager.createQuery(jpql);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        return (List<Book>) query.getResultList();
    }


}
