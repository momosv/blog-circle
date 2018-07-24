package cn.momosv.blog.circle.service;


import cn.momosv.blog.circle.model.TbUserPO;
import cn.momosv.blog.base.mybatis.service.BasicService;

public interface UserService extends BasicService {
    TbUserPO selectByPrimaryKey1(Integer id);
}
