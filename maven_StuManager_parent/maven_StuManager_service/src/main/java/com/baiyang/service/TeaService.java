package com.baiyang.service;

import com.baiyang.domain.Page;
import com.baiyang.domain.QueryResult;
import com.baiyang.domain.Teacher;

import java.util.List;

public interface TeaService {
    /**
     * 查找所有老师信息
     *
     * @param page
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<Teacher> findAllTea(Page page, int pageNo, int pageSize);

    /**
     * 查找老师自己
     *
     * @param tno
     * @return
     */
    public Teacher findTeaByTno(int tno);

    /**
     * 老师更改自己的密码
     *
     * @param tno
     * @param newPassword
     * @return
     */
    public int updateTeaPass(int tno, String newPassword);

    /**
     * 管理员添加老师
     *
     * @param tea
     * @return
     */
    public int savaTea(Teacher tea);

    /**
     * 管理员更新老师
     * @param teacher
     * @return
     */

    public int updateTea(Teacher teacher);

    /**
     * 管理员删除老师
     * @param tno
     * @return
     */
    public int deleteTea(int tno);

    // 查询老师 start
    public List<QueryResult> findAllTeaByTno(int tno);

    public List<QueryResult> findAllTeaByTname(String tname);

    public List<QueryResult> findAllTeaByTcollege(String tcollege);

    public List<QueryResult> findAllTeaByTsex(String tsex);

    // 查询老师 end

}
