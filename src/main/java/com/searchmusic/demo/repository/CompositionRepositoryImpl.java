package com.searchmusic.demo.repository;

import com.searchmusic.demo.model.Album;
import com.searchmusic.demo.model.Artist;
import com.searchmusic.demo.model.Composition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompositionRepositoryImpl implements CompositionRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Object[]> findAllArtistComposition(int id) {
        return em.createNamedQuery(Composition.GET_ALL_ARTIST, Object[].class).setParameter(1, id).getResultList();
    }

    @Override
    public List<String> findAllAlbumWherePublishedComposition(String name) {
        return em.createNamedQuery(Composition.GET_ALL_ALBUM, String.class).setParameter(1, name).getResultList();
    }

    @Override
    public List<Object[]> getAllComposition() {
        return em.createNamedQuery(Composition.GET_ALL, Object[].class).getResultList();
    }
}
