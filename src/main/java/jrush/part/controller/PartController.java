package jrush.part.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PartController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "index";
    }
}
