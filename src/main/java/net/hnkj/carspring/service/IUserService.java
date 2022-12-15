package net.hnkj.carspring.service;

import net.hnkj.carspring.model.User;
import net.hnkj.carspring.utils.PageBean;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IUserService {
    //禁用用户
    int updateStatusByUserid(Integer userid);

    //新增用户
    int insertSelective(User record);

    @Transactional(readOnly = true)
    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

   //重置密码
    int updatePwdByPrimaryKey(User user);

    //根据用户名查询用户
    @Transactional(readOnly = true)
    User selectByUsername(String username);

    //查询所有用户
    @Transactional(readOnly = true)
    List<User> listUser(User user, PageBean pageBean);

    //启用用户
    int enable(Integer userid);

    //重置密码
    int resetPwd(User user);
}