package com.baiyang.service;


import com.baiyang.domain.Student;
import com.baiyang.domain.Teacher;

public interface LoginService {
	public Teacher loginTea(Teacher tea);
    public Student loginStu(Student stu);
}
