package com.controlcenter.controller;

import com.controlcenter.properties.GilrProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GilrProperties gilrProperties;
   // @RequestMapping(value = "/say",method = RequestMethod.POST )
    @PostMapping(value = "/say")//推荐
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id:" +id;
    }
}
