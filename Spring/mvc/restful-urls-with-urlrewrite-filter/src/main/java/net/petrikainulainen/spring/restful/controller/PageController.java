package net.petrikainulainen.spring.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Petri Kainulainen
 */
@Controller
public class PageController {
    protected static final String PAGE_VIEW = "page";
    
    @RequestMapping(value="/page", method = RequestMethod.GET)
    public String showPage() {
        return PAGE_VIEW;
    }
}
