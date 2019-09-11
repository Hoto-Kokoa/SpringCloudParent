package com.test.controller;


import com.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest")
public class RestfulController {

    @RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String testGetResoure(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "get";
    }


    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    @ResponseBody
    public String testInsertResource(String username, String password) {
        System.out.println(username+";" + password);
        return "得到";
    }

    @RequestMapping(value = "/resource",method = RequestMethod.PUT)
    @ResponseBody
    public String testPutResource(String username, String password) {
        System.out.println("put");
        System.out.println(username + ";" + password);
        return "put";
    }

    @RequestMapping(value = "/resource", method = RequestMethod.DELETE)
    @ResponseBody
    public String testDeleteResource(String username,String password) {
        System.out.println("delete" + username+";" + password);
        return "delete";
    }


}
