package com.baiyang.service;


import com.baiyang.domain.QueryResult;

import java.util.List;

public interface QueryService {
    /**
     * 管理员查询信息
     */
    public List<QueryResult> findAllBySno(int sno);

    public List<QueryResult> findAllBySname(String sname);

    public List<QueryResult> findAllBySclass(String sclass);

    public List<QueryResult> findAllByCname(String cname);

    public List<QueryResult> findAllByCno(int cno);

    public List<QueryResult> findAllByRoom(String cclassroom);

    public List<QueryResult> findAllByCcredit(Double ccredit);

}
