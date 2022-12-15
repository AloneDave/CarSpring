package net.hnkj.carspring.service.impl;

import net.hnkj.carspring.mapper.UserMapper;
import net.hnkj.carspring.model.User;
import net.hnkj.carspring.service.IUserService;
import net.hnkj.carspring.utils.PageBean;
import net.hnkj.carspring.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int updateStatusByUserid(Integer userid) {
        return userMapper.updateStatusByUserid(userid);
    }

    @Override
    public int insertSelective(User user) {

        String salt = PasswordHelper.createSalt();
        String password = PasswordHelper.createCredentials(user.getPassword(),salt);
        user.setSalt(salt);
        user.setPassword(password);
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectByPrimaryKey(Integer userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updatePwdByPrimaryKey(User user) {
        return userMapper.updatePwdByPrimaryKey(user);
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> listUser(User user, PageBean pageBean) {
        return userMapper.listUser(user);
    }

    @Override
    public int enable(Integer userid) {
        return userMapper.enable(userid);
    }

    @Override
    public int resetPwd(User user) {
        //前端传过来的只有userid
        String salt = PasswordHelper.createSalt();
        String password = PasswordHelper.createCredentials("123456",salt);
        user.setSalt(salt);
        user.setPassword(password);

        return userMapper.resetPwd(user);
    }
}
