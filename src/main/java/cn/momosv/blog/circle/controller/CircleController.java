package cn.momosv.blog.circle.controller;

import cn.momosv.blog.base.redis.service.RedisUserService;
import cn.momosv.blog.circle.model.TbUserPO;
import cn.momosv.blog.circle.service.UserService;
import cn.momosv.blog.common.model.base.BasicExample;
import cn.momosv.blog.common.model.base.Msg;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CircleController {

    @Autowired
    UserService userService;


    @ResponseBody
    @RequestMapping("addUser")
    public Object addUser() throws Exception {
        TbUserPO userPO = new TbUserPO();
        userPO.setUserName("momo");
        userService.insertOne(userPO);
        BasicExample e = new BasicExample(TbUserPO.class);
        BasicExample.Criteria c= e.createCriteria();
        Page page = PageHelper.startPage(1,5);

        List<TbUserPO> userPO1= userService.selectByExample(e);
        PageInfo info = new PageInfo(page.getResult());
        return new Msg().add("page",info);
    }
}
