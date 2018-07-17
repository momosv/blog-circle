package cn.momosv.blog.circle.dao;


import cn.momosv.blog.circle.model.TbUserPO;
import cn.momosv.blog.common.dao.BasicMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserPOMapper extends BasicMapper {
    TbUserPO selectByPrimaryKey(String id);
}