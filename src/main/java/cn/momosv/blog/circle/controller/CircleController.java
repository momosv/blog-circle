package cn.momosv.blog.circle.controller;

import cn.momosv.blog.circle.model.TbUserPO;
import cn.momosv.blog.circle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CircleController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("addUser")
    public String addUser(){
        TbUserPO userPO = new TbUserPO();
        userPO.setId(UUID.randomUUID().toString());
        userPO.setUserName("momo");
        userService.insertOne(userPO);
        TbUserPO userPO1= userService.selectByPrimaryKey1(userPO.getId());
        return userPO1.toString();
    }
}
