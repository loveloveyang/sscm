package com.baiyang.service.impl;

import com.baiyang.dao.StudentDao;
import com.baiyang.dao.TeacherDao;
import com.baiyang.domain.Student;
import com.baiyang.domain.Teacher;
import com.baiyang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    public Teacher loginTea(Teacher tea) {
        System.out.println("登录老师的方法开始执行-----业务层");
        return teacherDao.loginTea(tea);
    }

    public Student loginStu(Student stu) {
        System.out.println("登录学生的方法开始执行-----业务层");
        return studentDao.loginStu(stu);
    }


}
