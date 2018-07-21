package com.controlcenter.controller;

import com.controlcenter.properties.GilrProperties;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TemplateController {
    @Autowired
    private GilrProperties gilrProperties;
    @RequestMapping(value = "/tem",method = RequestMethod.GET )
    public String say(){
        return "index";
    }
}
