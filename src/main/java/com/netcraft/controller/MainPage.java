package com.netcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class MainPage {

    @RequestMapping(value = "/")
    public ModelAndView test() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }
}
