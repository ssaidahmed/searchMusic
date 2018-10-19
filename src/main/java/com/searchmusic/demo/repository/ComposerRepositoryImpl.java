package com.searchmusic.demo.repository;

import com.searchmusic.demo.model.Composer;
import com.searchmusic.demo.model.Composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ComposerRepositoryImpl implements ComposerRepository{

    @PersistenceContext
    private EntityManager em;

       @Override
    public List<String> findAllCompositionComposer(String firstName, String lastName) {
        return em.createNamedQuery(Composer.FIND_ALL_COMPOS_COMPOSER, String.class).setParameter(1, firstName).setParameter(2, lastName).getResultList();
    }
}
