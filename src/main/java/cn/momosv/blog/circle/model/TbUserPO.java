package cn.momosv.blog.circle.model;


import cn.momosv.blog.base.mybatis.model.base.IBaseDBPO;

public class TbUserPO extends IBaseDBPO {
    private Integer id;

    private String userName;

    private String userPsw;

    private String headPic;

    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw == null ? null : userPsw.trim();
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String _getTableName() {
        return "tb_user";
    }

    @Override
    public Integer _getPKValue() {
        return id;
    }

    @Override
    public void _setPKValue(Object var1) {
        this.id= (Integer) var1;
    }

    @Override
    public  String  _getPKColumnName(){
        return "id";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}