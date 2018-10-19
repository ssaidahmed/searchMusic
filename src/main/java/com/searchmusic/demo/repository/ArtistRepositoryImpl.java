package com.searchmusic.demo.repository;

import com.searchmusic.demo.model.Artist;
import com.searchmusic.demo.model.Composition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class ArtistRepositoryImpl implements ArtistRepository{

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<String> findAllGroupsWhereSangArtist(String firstName, String lastName) {
        return em.createNamedQuery(Artist.FIND_ALL_GROUP, String.class).setParameter(1, firstName).setParameter(2, lastName).getResultList();
    }

    @Override
    public List<String> findAllCompositionArtist(String firstName, String lastName) {
        return em.createNamedQuery(Artist.FIND_ALL_COMPOSITION, String.class).setParameter(1, firstName).setParameter(2, lastName).getResultList();
    }
}
