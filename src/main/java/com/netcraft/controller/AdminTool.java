package com.netcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class AdminTool {

    @RequestMapping(value = "/admin")
    public ModelAndView test() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("admin");

        return modelAndView;
    }
}
