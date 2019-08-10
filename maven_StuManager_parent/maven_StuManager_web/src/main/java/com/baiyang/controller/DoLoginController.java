package com.baiyang.controller;

import com.baiyang.domain.Admin;
import com.baiyang.domain.Student;
import com.baiyang.domain.Teacher;
import com.baiyang.domain.User;
import com.baiyang.service.CouService;
import com.baiyang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


/**
 * 用户登录
 */
@Controller("doLoginController")
@SessionAttributes(value = {"student", "teacher","admin"}, types = {Student.class, Teacher.class,Admin.class})
public class DoLoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 老师和学生的登录方法
     * Model model：添加request的域对象而通过SessionAttributes存储到session的域对象中
     */
    @RequestMapping(path = "/loginUser", method = RequestMethod.POST)
    public String login(User user, String type, Model model) {
        try {
            System.out.println("开始执行login方法" + user);
            System.out.println("type值是：" + type);
            int userno = Integer.parseInt(user.getUsername());
            String password = user.getPassword();
            if (type.equals("tea")) {
                System.out.println("老师的页面");
                Teacher tea = new Teacher(userno, null, password);
                Teacher teacher = loginService.loginTea(tea);
                model.addAttribute("teacher", teacher);
                if (teacher != null) {
                    System.out.println("老师登录成功");
                    return "forward:teacherPage";
                } else {
                    System.out.println("老师登录失败");
                    return "redirect:login.jsp";
                }
            } else if (type.equals("stu")) {
                Student stu = new Student(userno, null, password, null, null);
                Student student = loginService.loginStu(stu);
                //底层会存储到request域对象中
                model.addAttribute("student", student);
                if (student != null) {
                    System.out.println("学生登录成功");
                    return "forward:studentPage";
                } else {
                    System.out.println("学生登录失败");
                    return "redirect:login.jsp";
                }
            } else if (type.equals("admin")) {
                System.out.println("管理员的页面");
                Admin admin1 = new Admin(userno,null,password,null);
                Admin admin = loginService.loginAdmin(admin1);
                model.addAttribute("admin", admin);
                if (admin != null) {
                    System.out.println("管理员登录成功");
                    return "forward:adminPage";
                } else {
                    System.out.println("管理员登录失败");
                    return "redirect:login.jsp";
                }
            } else {
                System.out.println("管理员登录失败");
                return "redirect:login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录异常！！！重定向到login.jsp页面");
            System.out.println("传递的参数可能为空");
            return "redirect:login.jsp";
        }
    }
}
