package cn.momosv.blog.circle.service.impl;


import cn.momosv.blog.circle.dao.TbUserPOMapper;
import cn.momosv.blog.circle.model.TbUserPO;
import cn.momosv.blog.circle.service.UserService;
import cn.momosv.blog.common.service.impl.BasicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl extends BasicServiceImpl implements UserService {

    @Autowired
    private TbUserPOMapper userMapper;

    @Resource
    public void setUserMapper(TbUserPOMapper userMapper) {
        setMapper(userMapper);
    }

    @Override
    public TbUserPO selectByPrimaryKey1(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
