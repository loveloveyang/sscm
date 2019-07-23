package com.baiyang.service.impl;

import com.baiyang.dao.StuDao;
import com.baiyang.domain.Student;
import com.baiyang.domain.Teacher;
import com.baiyang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StuDao stuDao;

    public Teacher loginTea(Teacher tea) {

        return null;
    }

    public Student loginStu(Student stu) {
        System.out.println("业务层：登录学生的方法执行中");
        return stuDao.loginStu(stu);
    }


}
