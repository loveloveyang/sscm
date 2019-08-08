package com.baiyang.service.impl;

import com.baiyang.dao.CourseDao;
import com.baiyang.domain.Course;
import com.baiyang.domain.Page;
import com.baiyang.domain.QueryResult;
import com.baiyang.service.CouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("couService")
public class CouServiceImpl implements CouService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAllCou(Page page, int pageNo, int pageSize) {
        System.out.println("查找所有课程-----业务层");
        int totleElements = courseDao.findAllCouCount();
        page.setTotleElements(totleElements);
        return courseDao.findAllCou(page.getStartNum(), page.getEndNum());
    }

    @Override
    public List<Course> findCouBySno(int sno) {
        System.out.println("通过学生查找课程-----业务层");
        return courseDao.findCouBySno(sno);
    }

    @Override
    public double findScreByCno(int cno) {
        System.out.println("通过课程号查找该课程学分-----业务层");
        return courseDao.findScreByCno(cno);
    }

    @Override
    public Set<Course> findCouStuByCno(int cno) {
        System.out.println("通过学号查找学生与课程-----业务层");
        return courseDao.findCouStuByCno(cno);
    }

    @Override
    public int updateCou(Course course) {
        System.out.println("更新课程-----业务层");
        return courseDao.updateCou(course);
    }

    @Override
    public int deleteCou(int cno) {
        System.out.println("删除课程-----业务层");
        return courseDao.deleteCou(cno);
    }

    @Override
    public int saveCou(Course course) {
        System.out.println("添加课程-----业务层");
        return courseDao.saveCou(course);
    }

    @Override
    public Course findCouByCno(int cno) {
        return courseDao.findCouByCno(cno);
    }


    //课程查询   start

    @Override
    public List<QueryResult> findCouByCname(String cname) {
        return courseDao.findCouByCname(cname);
    }

    @Override
    public List<QueryResult> findCouByCcredit(Double ccredit) {
        return courseDao.findCouByCcredit(ccredit);
    }

    @Override
    public List<QueryResult> findCouByCclassroom(String cclassroom) {
        return courseDao.findCouByCclassroom(cclassroom);
    }

    @Override
    public List<QueryResult> findCouByCno1(int cno1) {
        return courseDao.findCouByCno1(cno1);
    }

    //课程查询   end
}
