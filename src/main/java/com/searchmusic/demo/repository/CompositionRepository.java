package com.searchmusic.demo.repository;

import com.searchmusic.demo.model.Album;
import com.searchmusic.demo.model.Artist;
import com.searchmusic.demo.model.Composition;

import java.util.List;

public interface CompositionRepository {

    List<Object[]> findAllArtistComposition(int id);

    List<String> findAllAlbumWherePublishedComposition(String name);

    List<Object[]> getAllComposition();

}
