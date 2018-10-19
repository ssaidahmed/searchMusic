package com.searchmusic.demo.repository;


import java.util.List;

public interface ComposerRepository {

    List<String> findAllCompositionComposer(String firstName, String lastName);

}
