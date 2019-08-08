package com.baiyang.service.impl;

import com.baiyang.dao.QueryDao;
import com.baiyang.domain.QueryResult;
import com.baiyang.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("queryService")
public class QueryServiceImpl implements QueryService {
    @Autowired
    private QueryDao queryDao;
    @Override
    public List<QueryResult> findAllBySno(int sno) {
        System.out.println("通过学号查询选课关系开始执行-----业务层");
        return queryDao.findAllBySno(sno);
    }

    @Override
    public List<QueryResult> findAllBySname(String sname) {
        System.out.println("通过学生姓名查询选课关系开始执行-----业务层");
        return queryDao.findAllBySname(sname);
    }

    @Override
    public List<QueryResult> findAllBySclass(String sclass) {
        System.out.println("通过班级查询选课关系开始执行-----业务层");
        return queryDao.findAllBySclass(sclass);
    }

    @Override
    public List<QueryResult> findAllByCname(String cname) {
        System.out.println("通过课程名查询选课关系开始执行-----业务层");
        return queryDao.findAllByCname(cname);
    }

    @Override
    public List<QueryResult> findAllByCno(int cno) {
        System.out.println("通过课程号查询选课关系开始执行-----业务层");
        return queryDao.findAllByCno(cno);
    }

    @Override
    public List<QueryResult> findAllByRoom(String cclassroom) {
        System.out.println("通过教室查询选课关系开始执行-----业务层");
        return queryDao.findAllByRoom(cclassroom);
    }

    @Override
    public List<QueryResult> findAllByCcredit(Double ccredit) {
        return null;
    }
}
