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
    public Album getEmploye (@PathVariable(value= "id") Long id){

        Optional<Album> optionalEmploye = albumRepository.findById(id);
        if(optionalEmploye.isEmpty()){
            //404
            throw new EntityNotFoundException("l'employe d'identifiant" +id+  "n'a pas été trouvé");
        }
        return optionalEmploye.get();
    }

    @GetMapping(value = "/index")
    public String getConnectionPage() {
        return "index";
    }
}
