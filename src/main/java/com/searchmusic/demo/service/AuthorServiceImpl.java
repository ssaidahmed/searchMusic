package com.searchmusic.demo.service;

import com.searchmusic.demo.model.Composition;
import com.searchmusic.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{


    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<String> findAllCompositionAuthor(String firstLastName) {
        String nameAuthor[] = firstLastName.split(" ");
        return authorRepository.findAllCompositionAuthor(nameAuthor[0].toLowerCase(), nameAuthor[1].toLowerCase());
    }
}
