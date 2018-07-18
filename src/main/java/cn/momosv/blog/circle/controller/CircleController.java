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
    public String addUser() throws Exception {
        TbUserPO userPO = new TbUserPO();
        userPO.setUserName("momo");
        userService.insertOne(userPO);
        TbUserPO userPO1= (TbUserPO) userService.selectByPrimaryKey(TbUserPO.class,"1");
        return userPO1.toString();
    }
}
