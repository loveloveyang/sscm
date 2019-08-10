package com.baiyang.service.impl;

import com.baiyang.dao.StudentDao;
import com.baiyang.domain.Page;
import com.baiyang.domain.QueryResult;
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
    public List<Student> findALLStudent(Page page, int pageNo, int pageSize) {
        System.out.println("查找所有选课学生的方法开始执行-----业务层");
        int totleElements = studentDao.findStuCount();
        page.setTotleElements(totleElements);
        return studentDao.findALLStudent(page.getStartNum(),page.getEndNum());
    }

    @Override
    public List<Student> findALLStudent1(Page page, int pageNo, int pageSize) {
        System.out.println("查找所有学生的方法开始执行-----业务层");
        int totleElements = studentDao.findStuCount1();
        page.setTotleElements(totleElements);
        return studentDao.findALLStudent1(page.getStartNum(),page.getEndNum());
    }

    @Override
    public List<Student> findALLStudent2(Page page, int pageNo, int pageSize, float minScredit) {
        System.out.println("查找所有选课学生(含最低学分)的方法开始执行-----业务层");
        int totleElements = studentDao.findStuCount2(minScredit);
        page.setTotleElements(totleElements);
        return studentDao.findALLStudent(page.getStartNum(),page.getEndNum());
    }

    @Override
    public Double findScreBySno(int sno) {
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
    public int updateStuPass(int sno, String newPassword) {
        System.out.println("更新学生密码开始执行-----业务层");
        return studentDao.updateStuPass(sno,newPassword);
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

    // 老师查询学生   start
    @Override
    public List<QueryResult> findStuBySno1(int sno1) {
        return studentDao.findStuBySno1(sno1);
    }

    @Override
    public List<QueryResult> findStuBySname(String sname) {
        return studentDao.findStuBySname(sname);
    }

    @Override
    public List<QueryResult> findStuBySclass(String sclass) {
        return studentDao.findStuBySclass(sclass);
    }

    @Override
    public List<QueryResult> findStuBySsex(String ssex) {
        return studentDao.findStuBySsex(ssex);
    }

    // 老师查询学生   end

    // 管理员查询学生   start
    @Override
    public List<QueryResult> findStuBySno2(int sno2) {
        return studentDao.findStuBySno2(sno2);
    }

    @Override
    public List<QueryResult> findStuBySname2(String sname) {
        return studentDao.findStuBySname2(sname);
    }

    @Override
    public List<QueryResult> findStuBySclass2(String sclass) {
        return studentDao.findStuBySclass2(sclass);
    }

    @Override
    public List<QueryResult> findStuBySsex2(String ssex) {
        return studentDao.findStuBySsex2(ssex);
    }
    // 管理员查询学生   end
}
