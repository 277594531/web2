package com.springapp.mvc;

import com.springapp.mvc.model.Person;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by yexianshan on 2016/7/16.
 */
@Controller
public class PersonController {
    @RequestMapping("/person1")
    public String toPerson(Person p){
        System.out.println(p.getName() + " " + p.getAge());

        p = new Person();
        p.setName("h");
        p.setAge(11);
        return "p1";
    }

    @RequestMapping("/date")
    public String date(Date date){
        System.out.println(date);
        return "p1";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    @RequestMapping("/show")
    public String showPerson(Map<String, Object> map){
        Person p = new Person();
        map.put("p", p);
        p.setAge(20);;
        p.setName("jayjay");;
        map.put("name", p.getName());
        map.put("age", p.getAge());
        return "p1";
    }

    @RequestMapping("/getPerson")
    public void getPerson(String name, PrintWriter pw){
        pw.write("hello,"+name);
    }

    @RequestMapping("/name")
    public String sayHello(){
        return "p1";
    }

    @RequestMapping("/login")
    public String login(String userName, String password,Map<String, Object> map){
        map.put("userName", userName);
        map.put("password", password);
        return "p1";
    }

    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:login";
    }


}
