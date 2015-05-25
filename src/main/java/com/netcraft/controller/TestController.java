package com.netcraft.controller;

import com.netcraft.hibernate.service.*;
import com.netcraft.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Set;

@Controller
public class TestController {

    @Autowired
    private AttributeService attributeService;
    @Autowired
    private ObjectService objectService;
    @Autowired
    private ObjectTypeService objectTypeService;
    @Autowired
    private ParamService paramService;
    @Autowired
    private ReferenceService referenceService;
    @Autowired
    private AttrGroupService attrGroupService;

    @ModelAttribute
    public void addingCommonObjects(Model model1){
        model1.addAttribute("headerMsg", "Hello I am Header!");
    }


    @RequestMapping(value = "/test")
    public ModelAndView test() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("testpage");

        System.out.println("[TestController] objectService = " + objectService);
        System.out.println("[TestController] attributeService = " + attributeService);
        System.out.println("[TestController] paramService = " + paramService);
        System.out.println("[TestController] referenceService = " + referenceService);

        NCObject object = objectService.getObject(1);
        Attribute attribute = attributeService.getAttribute(1);
        ObjectType objectType = objectTypeService.getObjectType(1);
        Param param = paramService.getParam(attribute.getAttr_id(), object.getObject_id());
        Reference reference = referenceService.getReference(attribute.getAttr_id(), object.getObject_id());
        AttrGroup attrGroup = attrGroupService.getAttrGroup(1);

        System.out.println("[TestController] object = " + object.getName());
        System.out.println("[TestController] attribute = " + attribute.getName());
        System.out.println("[TestController] param = " + param.getValue());
        System.out.println("[TestController] reference = " + reference.getReference());
        System.out.println("[TestController] attrGroup = " + attrGroup.getName());

        modelAndView.addObject("object", object);
        modelAndView.addObject("objectType", objectType);
        modelAndView.addObject("attribute", attribute);
        modelAndView.addObject("param2", param);
        modelAndView.addObject("reference", reference);
        modelAndView.addObject("attrGroup", attrGroup);

        System.out.println("[TestController] DONE");

        return modelAndView;
    }
}
