package net.hnkj.carspring.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import net.hnkj.carspring.model.User;
import net.hnkj.carspring.service.IUserService;
import net.hnkj.carspring.utils.JsonData;
import net.hnkj.carspring.utils.PageBean;
import net.hnkj.carspring.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //验证码工具类
    private LineCaptcha lineCaptcha;
    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public JsonData login(User user,String code){
        //1.调用service层的用户名查询用户
        User u = userService.selectByUsername(user.getUsername());

        //实例化jsonData对象
        JsonData jsonData = new JsonData();

        //2.判断
        if(null==u){ //如果u为空,表示数据库中没有对应的用户
            jsonData.setCode(0);
            jsonData.setMessage("用户名不存在,请重新输入");
        }else{   //对应的用户在数据库存在,存在就匹配密码  user.getPassword()用户输入的密码  u.getPassword() 数据库保存的密码
            String password = PasswordHelper.createCredentials(user.getPassword(),u.getSalt());
            //password为用户输入的密码加密后的密码
            if(!u.getPassword().equals(password)){  //如果不匹配 表示密码错误 登录失败
                jsonData.setCode(0);
                jsonData.setMessage("密码错误,请重新输入");
            }else{
                //lineCaptcha.getCode() 自动生成的验证码
                //与前端传回的code字符进行匹配
                if(code!=null && code.equals(lineCaptcha.getCode())){ //如果匹配 表示信息正确 登录成功
                    jsonData.setCode(1);
                    jsonData.setMessage("信息正确，登录成功");
                }else{
                    jsonData.setCode(0);
                    jsonData.setMessage("验证码错误");
                }
            }
        }
        return jsonData;
    }


    /**
     * 查询所有用户
     * @param user
     * @param pageBean
     * @return
     */
    @RequestMapping("/list")
    public JsonData listUser(User user, PageBean pageBean){
        //1.调用service层
        List<User> users = userService.listUser(user, pageBean);

        //实例化jsonData对象
        JsonData jsonData = new JsonData();

       //将查询出来的数据放入到jsonData中
        jsonData.setCode(1);
        jsonData.setMessage("查询成功");
        jsonData.setRows(users);
        jsonData.setTotal(pageBean.getTotal());

        return jsonData;
    }


    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public JsonData addUser(User user){
        //1.调用service层
        int i = userService.insertSelective(user);

        //实例化jsonData对象
        JsonData jsonData = new JsonData();

        if(i==1){
            jsonData.setCode(1);
            jsonData.setMessage("新增成功");
        }else{
            jsonData.setCode(0);
            jsonData.setMessage("新增用户失败");
        }
        return jsonData;
    }


    /**
     * 重置密码
     * @param user
     * @return
     */
    @RequestMapping("/resetPwd")
    public JsonData resetPwd(User user){
        //1.调用service层
        int i = userService.resetPwd(user);

        //实例化jsonData对象
        JsonData jsonData = new JsonData();

        if(i==1){
            jsonData.setCode(1);
            jsonData.setMessage("重置密码成功");
        }else{
            jsonData.setCode(0);
            jsonData.setMessage("重置失败");
        }
        return jsonData;

    }

    /**
     * 禁用用户
     * @param user
     * @return
     */
    @RequestMapping("/disable")
    public JsonData disable(User user){
        //1.调用service层
        int i = userService.updateStatusByUserid(user.getUserid());

        //实例化jsonData对象
        JsonData jsonData = new JsonData();
        if(i==1){
            jsonData.setCode(1);
            jsonData.setMessage("已禁用");
        }else{
            jsonData.setCode(0);
            jsonData.setMessage("禁用失败");
        }

        return jsonData;
    }


    /**
     * 启用用户
     * @param user
     * @return
     */
    @RequestMapping("/enable")
    public JsonData enable(User user){
        //1.调用service层
        int i = userService.enable(user.getUserid());

        //实例化jsonData对象
        JsonData jsonData = new JsonData();

        if(i==1){
            jsonData.setCode(1);
            jsonData.setMessage("已启用");
        }else{
            jsonData.setCode(0);
            jsonData.setMessage("启用失败");
        }
        return jsonData;
    }

    /**
     *  生成验证码
     * @param response
     * @throws IOException
     */
    @GetMapping("/getCode")
    public void getCode(HttpServletResponse response) throws IOException {
        //1.验证码对象HuTool定义图形验证码的长和宽，验证码的位数，干扰线的条数
        lineCaptcha = CaptchaUtil.createLineCaptcha(116,36,4,10);
        //2.HttpServletResponse 用于将生成的验证码响应到页面展示
        response.setContentType("image/jpeg");
        response.setHeader("Pragma","No-cache");
        //3.将验证码图片响应给前端页面
        ServletOutputStream outputStream = response.getOutputStream();
        lineCaptcha.write(outputStream);
        //关闭输出流
        outputStream.close();
    }

}
