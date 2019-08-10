package com.baiyang.service.impl;

import com.baiyang.dao.TeacherDao;
import com.baiyang.domain.Page;
import com.baiyang.domain.QueryResult;
import com.baiyang.domain.Teacher;
import com.baiyang.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("teaService")
public class TeaServiceImpl implements TeaService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> findAllTea(Page page, int pageNo, int pageSize) {
        System.out.println("查找所有老师-----业务层");
        int totleElements = teacherDao.findAllTeaCount();
        page.setTotleElements(totleElements);
        return teacherDao.findAllTea(page.getStartNum(),page.getEndNum());
    }

    @Override
    public Teacher findTeaByTno(int tno) {
        return teacherDao.findTeaByTno(tno);
    }

    @Override
    public int updateTeaPass(int tno, String newTpassword) {
        return teacherDao.updateTeaPass(tno,newTpassword);
    }

    @Override
    public int savaTea(Teacher tea) {
        return teacherDao.savaTea(tea);
    }

    @Override
    public int updateTea(Teacher teacher) {
        System.out.println("更新学生密码开始执行-----业务层");
        return teacherDao.updateTea(teacher);
    }

    @Override
    public int deleteTea(int tno) {
        System.out.println("删除学生信息开始执行-----业务层");
        return teacherDao.deleteTea(tno);
    }

    @Override
    public List<QueryResult> findAllTeaByTno(int tno) {
        return teacherDao.findAllTeaByTno(tno);
    }

    @Override
    public List<QueryResult> findAllTeaByTname(String tname) {
        return teacherDao.findAllTeaByTname(tname);
    }

    @Override
    public List<QueryResult> findAllTeaByTcollege(String tcollege) {
        return teacherDao.findAllTeaByTcollege(tcollege);
    }

    @Override
    public List<QueryResult> findAllTeaByTsex(String tsex) {
        return teacherDao.findAllTeaByTsex(tsex);
    }
}
