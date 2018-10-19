package com.searchmusic.demo.service;

import com.searchmusic.demo.model.Composer;

import java.util.List;

public interface ComposerService {

    List<String> findAllCompositionComposer(String firstName);
}
