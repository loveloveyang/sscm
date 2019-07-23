package com.baiyang.controller;

import com.baiyang.domain.Student;
import com.baiyang.domain.Teacher;
import com.baiyang.domain.User;
import com.baiyang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * 用户登录
 */
@Controller("doLoginController")
@RequestMapping(path = "/dologin")
@SessionAttributes(value = {"student"}, types = {Student.class})
public class DoLoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    /**
     * 老师和学生的登录方法
     * Model model：添加request的域对象而通过SessionAttributes存储到session的域对象中
     */
    public String login(User user, String type, Model model) {
        System.out.println("开始执行login方法" + user);
        System.out.println("type值是：" + type);
        int userno = Integer.parseInt(user.getUsername());
        String password = user.getPassword();
        if (type.equals("tea")) {
            System.out.println("老师的页面");
            Teacher tea = new Teacher(userno, null, password);
            Teacher teacher = loginService.loginTea(tea);
            if (teacher != null) {
                System.out.println("老师登录成功");
                return "tea/teacher";
            } else {
                System.out.println("老师登录失败");
                return "../login";
            }
        } else if (type.equals("stu")) {
            System.out.println("学生页面");
            Student stu = new Student(userno, null, password, null, null);
            Student student = loginService.loginStu(stu);
            //底层会存储到request域对象中
            model.addAttribute("student", student);
            if (student != null) {
                System.out.println("学生登录成功");
                return "stu/student";
            } else {
                System.out.println("学生登录失败");
                return "../login";
            }
        }

        return "../login";
    }
}
