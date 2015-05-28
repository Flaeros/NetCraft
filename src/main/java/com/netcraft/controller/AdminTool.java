package com.netcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminTool {


    @ModelAttribute
    public void addingCommonObjects(Model model1){
        model1.addAttribute("title", "Admin Page!");
    }

    @RequestMapping(value = "")
    public ModelAndView all() throws SQLException {
        Map<String,String> pathVars = new HashMap<String, String>();
        pathVars.put("object_type", "0");
        return main(pathVars);
    }

    @RequestMapping(value = "/{object_type}")
    public ModelAndView main(@PathVariable Map<String,String> pathVars) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("admin");

        //long cant be 0, default = 0
        long object_type = Long.parseLong(pathVars.get("object_type"));

        modelAndView.addObject("object_type", object_type);

        return modelAndView;
    }
}
