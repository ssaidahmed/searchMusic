package com.searchmusic.demo.service;

import com.searchmusic.demo.model.Composition;

import java.util.List;

public interface AuthorService {

    List<String> findAllCompositionAuthor(String firstLastName);
}
