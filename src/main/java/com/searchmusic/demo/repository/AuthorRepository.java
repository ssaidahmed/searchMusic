package com.searchmusic.demo.repository;

import com.searchmusic.demo.model.Composition;

import java.util.List;

public interface AuthorRepository {

    List<String> findAllCompositionAuthor(String firstName, String lastName);

}
