package cn.momosv.blog.circle.dao;


import cn.momosv.blog.circle.model.TbUserPO;
import cn.momosv.blog.base.mybatis.dao.BasicMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserPOMapper extends BasicMapper {
    TbUserPO selectByPrimaryKey1(Integer id);
}