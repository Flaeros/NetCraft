package com.netcraft.controller;

import com.netcraft.model.Attribute;
import com.netcraft.model.HObject;
import com.netcraft.hibernate.Attribute.service.AttributeService;
import com.netcraft.hibernate.HObject.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class TestController {

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private ObjectService objectService;

    @ModelAttribute
    public void addingCommonObjects(Model model1){
        model1.addAttribute("headerMsg", "Hello I am Header!");
    }


    @RequestMapping(value = "/test")
    public ModelAndView test() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("testpage");

        System.out.println("[TestController] objectService = " + objectService);
        System.out.println("[TestController] attributeService = " + attributeService);

        HObject object = objectService.getObject(1);
        Attribute attribute = attributeService.getAttribute(1);

        System.out.println("[TestController] object = " + object.getName());
        System.out.println("[TestController] attribute = " + attribute.getName());

        modelAndView.addObject("object", object);
        modelAndView.addObject("attribute", attribute);

        return modelAndView;
    }
}
