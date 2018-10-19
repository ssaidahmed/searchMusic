package com.searchmusic.demo.service;

import com.searchmusic.demo.model.Artist;
import com.searchmusic.demo.model.Composition;

import java.util.List;

public interface ArtistService {

    List<String> findAllGroupsWhereSangArtist( String lastName);

    List<String> findAllCompositionArtist( String lastName);
}
