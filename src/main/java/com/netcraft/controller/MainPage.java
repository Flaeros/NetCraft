package com.netcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class MainPage {


    @ModelAttribute
    public void addingCommonObjects(Model model1){
        model1.addAttribute("title", "Main Page!");
    }

    @RequestMapping(value = "/")
    public ModelAndView test() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("main");

        return modelAndView;
    }
}
