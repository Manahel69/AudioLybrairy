package com.MyAudioLibrairy.web.Controller;

import com.MyAudioLibrairy.web.model.Album;
import com.MyAudioLibrairy.web.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;
    @RequestMapping(method = RequestMethod.GET, value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Album getAlbum (@PathVariable(value= "id") Long id){

        Optional<Album> optionalAlbum = albumRepository.findById(id);
        if(optionalAlbum.isEmpty()){
            //404
            throw new EntityNotFoundException("l'album d'identifiant" +id+  "n'a pas été trouvé");
        }
        return optionalAlbum.get();
    }


}
