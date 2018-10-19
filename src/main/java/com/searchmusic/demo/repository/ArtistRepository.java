package com.searchmusic.demo.repository;

import com.searchmusic.demo.model.Artist;
import com.searchmusic.demo.model.Composition;

import java.util.List;


public interface ArtistRepository {

    List<String> findAllGroupsWhereSangArtist(String firstName, String lastName);

    List<String> findAllCompositionArtist(String firstName, String lastName);
}
