package org.fobidb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class ViewController {

    @GetMapping("/index")
    public String listTeacher() {
        return "index";
    }

}
