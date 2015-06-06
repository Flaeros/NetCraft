package com.netcraft.controller;

import com.netcraft.hibernate.service.AttributeService;
import com.netcraft.hibernate.service.ObjectTypeService;
import com.netcraft.model.Attribute;
import com.netcraft.model.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping(value = "/bind_attr_to_type",method = RequestMethod.POST)
    public ResponseEntity bind_attr_to_type(@RequestParam("attr_id") String attr_id_str,
                                            @RequestParam("object_type_id") String object_type_id_str) throws SQLException{
        long attr_id = Long.parseLong(attr_id_str);
        long object_type_id = Long.parseLong(object_type_id_str);
        Attribute attribute = attributeService.getAttribute(attr_id);
        ObjectType objectType = objectTypeService.getObjectType(object_type_id);

        attribute.getObjectTypes().add(objectType);
        attributeService.updateAttribute(attribute);
        objectType.getAttributes().add(attribute);
        objectTypeService.updateObjectType(objectType);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/create_attr",method = RequestMethod.POST)
    public ResponseEntity create_attr(@RequestParam("name") String name,
                            @RequestParam("attr_group_id") String attr_group_id_str,
                            @RequestParam("attr_type_id") String attr_type_id_str,
                            @RequestParam("object_type_id") String object_type_id_str) throws SQLException{
        long attr_group_id=0;
        if(!attr_group_id_str.isEmpty())
            attr_group_id = Long.parseLong(attr_group_id_str);
        long attr_type_id = Long.parseLong(attr_type_id_str);
        long object_type_id = Long.parseLong(object_type_id_str);

        ObjectType objectType = objectTypeService.getObjectType(object_type_id);
        Set<ObjectType> objectTypes = new HashSet<ObjectType>();
        objectTypes.add(objectType);
        Attribute attribute = new Attribute(attr_type_id, name, objectTypes, (attr_group_id ==0 ) ? null : attr_group_id);
        attributeService.addAttribute(attribute);

        Set<Attribute> attributes = objectType.getAttributes();
        attributes.add(attribute);
        objectType.setAttributes(attributes);
        objectTypeService.updateObjectType(objectType);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/save_attr",method = RequestMethod.POST)
    public ResponseEntity save_attribute(@RequestParam("name") String name,
                                 @RequestParam("attr_id") String attr_id_str,
                                 @RequestParam("attr_group_id") String attr_group_id_str,
                                 @RequestParam("attr_type_id") String attr_type_id_id) throws SQLException{
        long attr_id = Long.parseLong(attr_id_str);
        long attr_group_id = Long.parseLong(attr_group_id_str);
        long attr_type_id = Long.parseLong(attr_type_id_id);
        Attribute attribute = attributeService.getAttribute(attr_id);
        if(attribute != null) {
            attribute.setName(name);
            attribute.setAttr_group_id(attr_group_id);
            attribute.setAttr_type_id(attr_type_id);
            attributeService.updateAttribute(attribute);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_attr",method = RequestMethod.POST)
    public ResponseEntity delete_attribute(@RequestParam("attr_id") String attr_id_str) throws SQLException{
        long attr_id = Long.parseLong(attr_id_str);
        Attribute attr_to_delete = attributeService.getAttribute(attr_id);
        attributeService.deleteAttribute(attr_to_delete);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/create_type",method = RequestMethod.POST)
    public ResponseEntity create_object_type(@RequestParam("name") String name,
                                   @RequestParam("parent_id") String parent_id_str) throws SQLException{
        long parent_id = Long.parseLong(parent_id_str);
        ObjectType new_OT = new ObjectType(null, name, parent_id);

        objectTypeService.addObjectType(new_OT);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/save_type",method = RequestMethod.POST)
    public ResponseEntity save_object_type(@RequestParam("name") String name,
                                 @RequestParam("object_type_id") String object_type_id_str) throws SQLException{
        long object_type_id = Long.parseLong(object_type_id_str);
        ObjectType objectType = objectTypeService.getObjectType(object_type_id);
        if(objectType != null) {
            objectType.setName(name);
            objectTypeService.updateObjectType(objectType);
            objectType.setAttributes(null);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_type",method = RequestMethod.POST)
    public ResponseEntity delete_object_type(@RequestParam("object_type_id") String object_type_id_str) throws SQLException{
        long object_type_id = Long.parseLong(object_type_id_str);
        ObjectType OT_to_delete = objectTypeService.getObjectType(object_type_id);
        objectTypeService.deleteObjectType(OT_to_delete);

        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/attr_data/{attr_id}")
    public @ResponseBody
    Attribute getAttrData(@PathVariable Map<String,String> pathVars) throws SQLException {
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

        //get all types to bind function except current
        List<ObjectType> allTypes = objectTypeService.getAllTypes();

        if(current_object_type != null) {
            Iterator<ObjectType> it = allTypes.iterator();
            while(it.hasNext()){
                ObjectType ot = it.next();
                if(ot.getObject_type_id() == current_object_type.getObject_type_id())
                    it.remove();
            }
        }


        //set values
        modelAndView.addObject("object_type_id", object_type_id);
        modelAndView.addObject("parentTypes", parentTypes);
        modelAndView.addObject("childTypes", childTypes);
        modelAndView.addObject("allTypes", allTypes);
        if(current_object_type != null)
            modelAndView.addObject("attributes", current_object_type.getAttributes());

        return modelAndView;
    }
}
