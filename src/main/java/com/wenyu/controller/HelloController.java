package com.wenyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 文宇 on 2017/3/13.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/index")
    public String helloIndex(Model model,String name){
        model.addAttribute("name",name);
        return "hello";
    }


}
