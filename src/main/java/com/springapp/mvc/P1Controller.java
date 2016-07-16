package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yexianshan on 2016/7/16.
 */
@Controller
@RequestMapping("/p1/")
public class P1Controller {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model){
        model.addAttribute("m1", "Page1 Hello");
        return "p1";
    }
}
