package com.netcraft.controller;

import com.netcraft.model.Attribute;
import com.netcraft.model.NCObjectORM;
import com.netcraft.util.hibernate.Attribute.AttributeDAO;
import com.netcraft.util.hibernate.Attribute.AttributeFactory;
import com.netcraft.util.hibernate.NCObjectORM.NCObjectORMFactory;
import com.netcraft.util.hibernate.NCObjectORM.NCObjectDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class TestController {

    @ModelAttribute
    public void addingCommonObjects(Model model1){
        model1.addAttribute("headerMsg", "Hello I am Header!");
    }


    @RequestMapping(value = "/test")
    public ModelAndView test() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("testpage");

        NCObjectDAO objectDAO  = NCObjectORMFactory.getInstance().getNCObjectDAO();
        AttributeDAO attributeDAO  = AttributeFactory.getInstance().getAttributeDAO();
        System.out.println("[TestController] objectDAO = " + objectDAO);
        System.out.println("[TestController] attributeDAO = " + attributeDAO);

        NCObjectORM object = objectDAO.getObject(1);
        Attribute attribute = attributeDAO.getAttribute(1);

        System.out.println("[TestController] object = " + object.getName());
        System.out.println("[TestController] attribute = " + attribute.getName());

        modelAndView.addObject("object", object);
        modelAndView.addObject("attribute", attribute);

        return modelAndView;
    }
}
