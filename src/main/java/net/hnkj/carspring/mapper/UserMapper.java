package net.hnkj.carspring.mapper;

import net.hnkj.carspring.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //禁用用户
    int updateStatusByUserid(Integer userid);

    //启用用户
    int enable(Integer userid);

    //新增用户
    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

   //重置密码
    int updatePwdByPrimaryKey(User user);

    //根据用户名查询用户
    User selectByUsername(String username);

    //查询所有用户
    List<User> listUser(User user);

    //重置密码
    int resetPwd(User user);
}