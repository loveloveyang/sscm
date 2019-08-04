package com.baiyang.service.impl;

import com.baiyang.dao.StudentDao;
import com.baiyang.domain.Student;
import com.baiyang.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Service("stuService")
public class StuServiceImpl implements StuService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findALLStudent() {
        System.out.println("查找所有学生的方法开始执行-----业务层");
        return studentDao.findALLStudent();
    }

    @Override
    public Student findScreBySno(int sno) {
        System.out.println("查找某个学生的总学分开始执行-----业务层");
        return studentDao.findScreBySno(sno);
    }

    @Override
    public Student findStuBySno(int sno) {
        return studentDao.findStuBySno(sno);
    }

    @Override
    public Iterator<Student> findAllByStu(String all) {
        System.out.println("查找所有学生，返回一个遍历器-----业务层");
        return null;
    }

    @Override
    public Set<Student> findStuCou() {
        System.out.println("查找所有的学生和课程开始执行-----业务层");
        return studentDao.findStuCou();
    }

    @Override
    public int updateStu(Student student) {
        System.out.println("更新学生信息开始执行-----业务层");
        return studentDao.updateStu(student);
    }

    @Override
    public int deleteStu(int sno) {
        System.out.println("删除学生信息开始执行-----业务层");
        return studentDao.deleteStu(sno);
    }

    @Override
    public int savaStu(Student stu) {
        System.out.println("添加学生信息开始执行-----业务层");
        return studentDao.saveStu(stu);
    }

}
