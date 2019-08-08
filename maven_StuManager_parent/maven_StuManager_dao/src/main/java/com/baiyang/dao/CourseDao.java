package com.baiyang.dao;

import com.baiyang.domain.Course;
import com.baiyang.domain.QueryResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseDao {
    /**
     * 查找所有课程
     *
     * @return List<Course>
     */
    public List<Course> findAllCou(@Param("startNum") int startNum, @Param("endNum")int endNum);

    /**
     * 查找所有课程的记录数
     */
    public int findAllCouCount();

    /**
     * 根据学号查找该学生选的所有课程
     *
     * @param sno
     * @return List<Course>
     */

    public List<Course> findCouBySno(int sno);

    /**
     * 查找该课程的学分
     *
     * @param con
     * @return double
     */
    public double findScreByCno(int con);

    /**
     * 根据课程号查询课程与学生
     *
     * @param cno
     * @return Set<Course>
     */
    public Set<Course> findCouStuByCno(int cno);

    /**
     * 根据课程号查找该课程
     */
    public Course findCouByCno(int cno);

    /**
     * 更新课程
     *
     * @param course
     * @return int
     */
    public int updateCou(Course course);

    /**
     * 删除课程
     *
     * @param cno
     * @return int
     */

    public int deleteCou(int cno);

    /**
     * 添加课程
     *
     * @param course
     * @return int
     */

    public int saveCou(Course course);

    /**
     * 根据课程名查找该课程
     */
    public List<QueryResult> findCouByCname(String cname);
    /**
     * 根据课程学分查找该课程
     */
    public List<QueryResult> findCouByCcredit(Double ccredit);
    /**
     * 根据课程教室查找该课程
     */
    public List<QueryResult> findCouByCclassroom(String cclassroom);
    /**
     * 根据课程号查找该课程
     */
    public List<QueryResult> findCouByCno1(int cno1);

}
