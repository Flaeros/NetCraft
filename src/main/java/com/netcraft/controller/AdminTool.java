package com.netcraft.controller;

import com.netcraft.hibernate.service.AttributeService;
import com.netcraft.hibernate.service.ObjectTypeService;
import com.netcraft.model.Attribute;
import com.netcraft.model.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping(value = "/admin/")
public class AdminTool {

    @Autowired
    private ObjectTypeService objectTypeService;
    @Autowired
    private AttributeService attributeService;


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

    @RequestMapping(value = "/create_type",method = RequestMethod.POST)
    public @ResponseBody ObjectType create_object_type(@RequestParam("name") String name,
                                                       @RequestParam("parent_id") String parent_id_str) throws SQLException{
        long parent_id = Long.parseLong(parent_id_str);
        System.out.println("[create_object_type]");
        System.out.println("name = " + name);
        System.out.println("parent_id = " + parent_id);
        ObjectType new_OT = new ObjectType(null, name, parent_id);

        objectTypeService.addObjectType(new_OT);

        return new_OT;
    }


    @RequestMapping(value = "/attr_data/{attr_id}")
    public @ResponseBody
    Attribute getAttrData(@PathVariable Map<String,String> pathVars) throws SQLException {
        System.out.println("[getAttrData]");

        long attr_id = Long.parseLong(pathVars.get("attr_id"));

        Attribute attribute = attributeService.getAttribute(attr_id);
        attribute.setObjectTypes(null);
        attribute.setParams(null);
        attribute.setReferences(null);

        return attribute;
    }

    @RequestMapping(value = "/{object_type}")
    public ModelAndView main(@PathVariable Map<String,String> pathVars) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("admin");

        //long cant be 0, default = 0
        long object_type_id = Long.parseLong(pathVars.get("object_type"));

        //get breadcrumbs
        List<ObjectType> parentTypes = objectTypeService.getParentTypes(object_type_id);
        ObjectType current_object_type = null;
        if(parentTypes != null) {
            Collections.reverse(parentTypes);
            current_object_type = objectTypeService.getObjectType(object_type_id);
            parentTypes.add(current_object_type);
        }

        //get child types
        List<ObjectType> childTypes = objectTypeService.getChildTypes(object_type_id);

        if(current_object_type != null)
            System.out.println("[getAttributes +AdminTool] getAttributes = " + current_object_type.getAttributes().toString());


        //set values
        modelAndView.addObject("object_type_id", object_type_id);
        modelAndView.addObject("parentTypes", parentTypes);
        modelAndView.addObject("childTypes", childTypes);
        if(current_object_type != null)
            modelAndView.addObject("attributes", current_object_type.getAttributes());

        return modelAndView;
    }
}
