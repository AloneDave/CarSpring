package net.hnkj.carspring.service.impl;

import net.hnkj.carspring.model.User;
import net.hnkj.carspring.service.IUserService;
import net.hnkj.carspring.utils.PageBean;
import net.hnkj.carspring.utils.PasswordHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void updateStatusByUserid() {
        user.setUserid(4);
        int i = userService.updateStatusByUserid(4);

    }

    @Test
    void enable() {
//        user.setUserid(3);
//        int i = userService.enable(3);

        user.setUserid(4);
        userService.resetPwd(user);
    }

    @Test
    void insertSelective() {
        String username = "wnag";
        String salt = PasswordHelper.createSalt();
        String password = PasswordHelper.createCredentials("123456",salt);
        user.setUsername(username);
        user.setPassword(password);
        user.setSalt(salt);
        user.setStatus(1);
        userService.insertSelective(user);

    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updatePwdByPrimaryKey() {
    }

    @Test
    void selectByUsername() {
        User lixin = userService.selectByUsername("lixin");
        System.out.println(lixin);
    }

    @Test
    void listUser() {
        List<User> users = userService.listUser(user, new PageBean());
        for (User u : users) {
            System.out.println(u);
        }
    }
}