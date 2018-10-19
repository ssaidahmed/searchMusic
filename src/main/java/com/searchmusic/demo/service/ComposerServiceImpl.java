package com.searchmusic.demo.service;


import com.searchmusic.demo.repository.ComposerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposerServiceImpl implements ComposerService{


    private ComposerRepository composerRepository;

    @Autowired
    public ComposerServiceImpl(ComposerRepository composerRepository) {
        this.composerRepository = composerRepository;
    }

    @Override
    public List<String> findAllCompositionComposer(String firstLastName) {

        String nameComposer[] = firstLastName.split(" ");
        return composerRepository.findAllCompositionComposer(nameComposer[0].toLowerCase(), nameComposer[1].toLowerCase());
    }
}
