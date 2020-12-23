package com.MyAudioLibrairy.web.Controller;

import com.MyAudioLibrairy.web.model.Album;
import com.MyAudioLibrairy.web.model.Artist;
import com.MyAudioLibrairy.web.repository.AlbumRepository;
import com.MyAudioLibrairy.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
@RestController
@RequestMapping("/artists")
public class ArtistController {
        @Autowired
        private ArtistRepository artistRepository;
        @RequestMapping(method = RequestMethod.GET, value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Artist getArtist (@PathVariable(value= "id") Long id){

                Optional<Artist> optionalArtist = artistRepository.findById(id);
                if(optionalArtist.isEmpty()){
                        //404
                        throw new EntityNotFoundException("l'artiste d'identifiant " +id+  " n'a pas été trouvé.");
                }
                return optionalArtist.get();
        }

      /*  @RequestMapping(method =  RequestMethod.GET,value="",produces = MediaType.APPLICATION_JSON_VALUE)
        public Artist searchByName(@RequestParam String name) {
                Artist artist = artistRepository.findByName(name);
                if (artist == null) {
                        throw new EntityNotFoundException("l'artiste de nom" + name + " n'a pas été trouvé");
                }
                return artist;
        }*/

        @RequestMapping(method =RequestMethod.GET, value = "",produces = MediaType.APPLICATION_JSON_VALUE)
        public Page<Artist> listArtists(
                @RequestParam Integer page,
                @RequestParam (defaultValue = "10") Integer size,
                @RequestParam (defaultValue = "name") String sortProperty,
                @RequestParam (value = "sortDirection", defaultValue = "ASC")String sortDirection)
        {
                if (page<0){
                        //400
                        throw new IllegalArgumentException("Le parametre paage doit être positif ou nul!");
                }
                if (size <=0 || size >50){
                        throw new IllegalArgumentException("le parametre size doit être compris entre 0 et 50");
                }
                if(!"ASC".equalsIgnoreCase(sortDirection)&& !"DESC".equalsIgnoreCase(sortDirection)){
                        throw new IllegalArgumentException("Le paramètre sortDirection doit valoir ASC ou DESC");
                }
                return artistRepository.findAll(PageRequest.of(page,size, Sort.Direction.fromString(sortDirection),sortProperty));
        }




}

