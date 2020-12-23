package com.MyAudioLibrairy.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistController
{
        @GetMapping(value = "/login")
        public String getConnectionPage() {
                return "Connexion";
        }

        }

