package com.searchmusic.demo.controller;

import com.searchmusic.demo.model.Composition;
import com.searchmusic.demo.service.ArtistService;
import com.searchmusic.demo.service.AuthorService;
import com.searchmusic.demo.service.ComposerService;
import com.searchmusic.demo.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MusicRestController {
    @Autowired
    private CompositionService compositionService;
    @Autowired
    private ComposerService composerService;
    @Autowired
    private ArtistService artistService;
    @Autowired
    private AuthorService authorService;


    @GetMapping("/all")
    public List<Object[]> getList(){
        return compositionService.getAllComposition();
    }

    @GetMapping("/findart/{id}")
    public List<Object[]> findAllArtistComposition(@PathVariable int id){
        return compositionService.findAllArtistComposition(id);
    }

    @GetMapping("/findallbum/{name}")
    public List<String> findAllAlbumWherePublishedComposition(@PathVariable String name){

        return compositionService.findAllAlbumWherePublishedComposition(name);
    }

    @GetMapping("/findcomp/{firstLastName}")
    public List<String> findAllCompositionComposer(@PathVariable String firstLastName){

        return composerService.findAllCompositionComposer(firstLastName);
    }

    @GetMapping("/findartcomp/{firstLastName}")
    public List<String> findArtistAllComposition( @PathVariable String firstLastName){

        return artistService.findAllCompositionArtist(firstLastName);
    }
    //

    @GetMapping("/findartgroup/{firstLastName}")
    public List<String> findAllGroupsWhereSangArtist(@PathVariable String firstLastName){

        return artistService.findAllGroupsWhereSangArtist(firstLastName);
    }
    @GetMapping("/findauthorcomp/{firstLastName}")
    public List<String> findAllCompositionAuthor(@PathVariable String firstLastName){

        return authorService.findAllCompositionAuthor(firstLastName);
    }
}
