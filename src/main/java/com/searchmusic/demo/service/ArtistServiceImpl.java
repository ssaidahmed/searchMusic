package com.searchmusic.demo.service;


import com.searchmusic.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService{


    private ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<String> findAllGroupsWhereSangArtist(String firstLastName) {
        String nameArtist[] = firstLastName.split(" ");
        return artistRepository.findAllGroupsWhereSangArtist(nameArtist[0].toLowerCase(), nameArtist[1].toLowerCase());
    }

    @Override
    public List<String> findAllCompositionArtist(String firstLastName) {

        String nameArtist[] = firstLastName.split(" ");
        return artistRepository.findAllCompositionArtist(nameArtist[0].toLowerCase(), nameArtist[1].toLowerCase());
    }
}
