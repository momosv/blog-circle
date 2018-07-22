package cn.momosv.blog.circle.service.impl;


import cn.momosv.blog.circle.dao.TbUserPOMapper;
import cn.momosv.blog.circle.model.TbUserPO;
import cn.momosv.blog.circle.service.UserService;
import cn.momosv.blog.common.service.impl.BasicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("userService")
public class UserServiceImpl extends BasicServiceImpl implements UserService {

    @Autowired
    private TbUserPOMapper userMapper;

   @Autowired
    public void setUserMapper(TbUserPOMapper userMapper) {
        setMapper(userMapper);
    }

    @Override
    public TbUserPO selectByPrimaryKey1(Integer id) {
        return userMapper.selectByPrimaryKey1(id);
    }
}
