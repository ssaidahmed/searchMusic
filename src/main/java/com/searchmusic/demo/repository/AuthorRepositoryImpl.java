package com.searchmusic.demo.repository;

import com.searchmusic.demo.model.Author;
import com.searchmusic.demo.model.Composition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<String> findAllCompositionAuthor(String firstName, String lastName) {
        return em.createNamedQuery(Author.FIND_ALL_COMPOS_AUTHOR, String.class).setParameter(1, firstName).setParameter(2, lastName).getResultList();
    }
}
