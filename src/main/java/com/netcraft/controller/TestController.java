package com.netcraft.controller;

import com.netcraft.model.NCObjectORM;
import com.netcraft.util.hibernate.HibernateFactory;
import com.netcraft.util.hibernate.NCObjectDAO;
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

        NCObjectDAO objectDAO  = HibernateFactory.getInstance().getNCObjectDAO();

        //NCObjectORM obj1 = new NCObjectORM();
        //obj1.setName("SecondObject");
        //objectDAO.addObject(obj1);

        NCObjectORM object1 = objectDAO.getObjectById(1);
        System.out.println("object name = " + object1.getName());
        System.out.println("object id = " + object1.getId());

        modelAndView.addObject("object1", object1);
        //modelAndView.addObject("name", obj1.getName());
        modelAndView.addObject("test", "OLOLO");

        return modelAndView;
    }
}
