package com.baiyang.dao;

import com.baiyang.domain.QueryResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryDao {
    public List<QueryResult> findAllBySno(int sno);

    public List<QueryResult> findAllBySname(String sname);

    public List<QueryResult> findAllBySclass(String sclass);

    public List<QueryResult> findAllByCname(String cname);

    public List<QueryResult> findAllByCno(int cno);

    public List<QueryResult> findAllByRoom(String cclassroom);
}
