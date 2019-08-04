package com.baiyang.service.impl;

import com.baiyang.dao.ScDao;
import com.baiyang.domain.Course;
import com.baiyang.domain.Sc;
import com.baiyang.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("scService")
public class ScServiceImpl implements ScService {
    @Autowired
    private ScDao scDao;
    @Override
    public List<Course> findScBySno(int sno) {
        System.out.println("查询选课关系开始执行-----业务层");
        return scDao.findScBySno(sno);
    }

    @Override
    public int delectSc(int sno, int cno) {
        System.out.println("通过sno，cno删除选课关系开始执行-----业务层");
        return scDao.delectSc(sno,cno);
    }

    @Override
    public int saveSc(Sc[] sc) {
        System.out.println("通过Sc[]添加选课关系开始执行-----业务层");
        return scDao.saveSc(sc);
    }

    @Override
    public int saveScBySnoCno(int sno, int cno) {
        System.out.println("通过学号课程号添加选课关系开始执行-----业务层");

        return scDao.saveScBySnoCno(sno,cno);
    }
}
