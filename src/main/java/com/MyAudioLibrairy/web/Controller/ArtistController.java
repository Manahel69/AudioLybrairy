package com.MyAudioLibrairy.web.Controller;

import com.MyAudioLibrairy.web.model.Album;
import com.MyAudioLibrairy.web.model.Artist;
import com.MyAudioLibrairy.web.repository.AlbumRepository;
import com.MyAudioLibrairy.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
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



}

