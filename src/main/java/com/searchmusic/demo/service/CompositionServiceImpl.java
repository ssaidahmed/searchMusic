package com.searchmusic.demo.service;

import com.searchmusic.demo.model.Album;
import com.searchmusic.demo.model.Artist;
import com.searchmusic.demo.model.Composition;
import com.searchmusic.demo.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompositionServiceImpl implements CompositionService {



    private CompositionRepository compositionRepository;

    @Autowired
    public CompositionServiceImpl(CompositionRepository compositionRepository) {
        this.compositionRepository = compositionRepository;
    }

    @Override
    public List<Object[]> findAllArtistComposition(int id) {
        return compositionRepository.findAllArtistComposition(id);
    }

    @Override
    public List<String> findAllAlbumWherePublishedComposition(String name) {

        return compositionRepository.findAllAlbumWherePublishedComposition(name.toLowerCase());
    }

    @Override
    public List<Object[]> getAllComposition() {
        return compositionRepository.getAllComposition();
    }
}
