package com.netcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class Application {

    @ModelAttribute
    public void addingCommonObjects(Model model1){
        model1.addAttribute("title", "Application Page!");
    }

    @RequestMapping(value = "/index")
    public ModelAndView test() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }
}
