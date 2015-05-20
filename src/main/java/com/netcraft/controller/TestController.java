package com.netcraft.controller;

import com.netcraft.hibernate.service.ObjectTypeService;
import com.netcraft.model.Attribute;
import com.netcraft.model.HObject;
import com.netcraft.hibernate.service.AttributeService;
import com.netcraft.hibernate.service.ObjectService;
import com.netcraft.model.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class TestController {

    @Autowired
    private AttributeService attributeService;
    @Autowired
    private ObjectService objectService;
    @Autowired
    private ObjectTypeService objectTypeService;

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
        ObjectType objectType = objectTypeService.getObjectType(1);

        System.out.println("[TestController] object = " + object.getName());
        System.out.println("[TestController] attribute = " + attribute.getName());

        modelAndView.addObject("object", object);
        modelAndView.addObject("objectType", objectType);
        modelAndView.addObject("attribute", attribute);

        Set<Attribute> attributes = objectType.getAttributes();


        System.out.println("[TestController] DONE");

        return modelAndView;
    }
}
