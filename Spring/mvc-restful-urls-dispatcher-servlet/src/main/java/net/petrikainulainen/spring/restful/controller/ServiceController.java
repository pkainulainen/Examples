package net.petrikainulainen.spring.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Petri Kainulainen
 */
@Controller
public class ServiceController {
    
    protected static final String SERVICE_VIEW = "service";
    
    @RequestMapping(value = "/service/{name}", method = RequestMethod.GET)
    public String showPage(@PathVariable("name") String name, Model model) {
        return SERVICE_VIEW;
    }
}
