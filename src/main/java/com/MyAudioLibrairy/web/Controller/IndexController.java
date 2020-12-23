package com.MyAudioLibrairy.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {

    @GetMapping(value = "/accueil")
    public String getConnectionPage() {
        return "accueil";
    }
}
