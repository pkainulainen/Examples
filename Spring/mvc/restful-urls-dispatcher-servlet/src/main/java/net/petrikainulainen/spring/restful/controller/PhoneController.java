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
public class PhoneController {
    protected static final String PHONE_VIEW = "phone";
    
    @RequestMapping(value="/phone/{model}", method = RequestMethod.GET)
    public String showPage(@PathVariable("model") String phoneModel, Model model) {
        return PHONE_VIEW;
    }
}
