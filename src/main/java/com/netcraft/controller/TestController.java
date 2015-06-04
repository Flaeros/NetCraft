package com.netcraft.controller;

import com.netcraft.hibernate.service.*;
import com.netcraft.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
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
        model1.addAttribute("title", "Test Page!");
    }


    @RequestMapping(value = "/test")
    public ModelAndView main() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("testpage");

        NCObject object = objectService.getObject(1);
        Attribute attribute = attributeService.getAttribute(1);
        ObjectType objectType = objectTypeService.getObjectType(1);
        Param param = paramService.getParam(attribute.getAttr_id(), object.getObject_id());
        Reference reference = referenceService.getReference(attribute.getAttr_id(), object.getObject_id());
        AttrGroup attrGroup = attrGroupService.getAttrGroup(1);

        List<ObjectType> parentTypesList = objectTypeService.getParentTypes(2);
        List<ObjectType> childTypesList = objectTypeService.getChildTypes(1);

        //AttrObjectTypeBasic attrObjectTypeBasic= attrObjectTypeBasicService.getAttrObjectTypeBasic(1,1);
        //System.out.println("attrObjectTypeBasic = " + attrObjectTypeBasic.getAttr_id() + " " + attrObjectTypeBasic.getObject_type_id());

        modelAndView.addObject("object", object);
        modelAndView.addObject("objectType", objectType);
        modelAndView.addObject("attribute", attribute);
        modelAndView.addObject("param2", param);
        modelAndView.addObject("reference", reference);
        modelAndView.addObject("attrGroup", attrGroup);
        modelAndView.addObject("parentTypesList", parentTypesList);
        modelAndView.addObject("childTypesList", childTypesList);
        //modelAndView.addObject("attrObjectTypeBasic", attrObjectTypeBasic);

        System.out.println("[TestController] DONE");

        return modelAndView;
    }
}
