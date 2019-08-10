package com.baiyang.dao;

import com.baiyang.domain.QueryResult;
import com.baiyang.domain.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    /**
     * 老师登录
     *
     * @param tea
     * @return
     */
    public Teacher loginTea(Teacher tea);
    /**
     * 老师信息
     */
    public List<Teacher> findAllTea(@Param("startNum") int startNum, @Param("endNum")int endNum);

    /**
     * 查找所有老师的记录数
     * @return
     */
    public int findAllTeaCount();

    /**
     * 查找老师自己的信息
     * @return
     */
    public Teacher findTeaByTno(int tno);

    /**
     * 老师修改自己的密码
     * @param tno
     * @param newTpassword
     * @return
     */
    public int updateTeaPass(@Param("tno") int tno,@Param("newTpassword") String newTpassword);

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
