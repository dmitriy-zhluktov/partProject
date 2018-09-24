package jrush.part.controller;

import jrush.part.model.dao.Part;
import jrush.part.model.service.PartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PartController {

    @Autowired
    private PartDAO partDao;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        List<Part> parts = partDao.list();
        return "index";
    }
}
