package com.baiyang.service;


import com.baiyang.domain.Course;
import com.baiyang.domain.Page;
import com.baiyang.domain.QueryResult;

import java.util.List;
import java.util.Set;

public interface CouService {

    /**
     * 查找所有课程
     *
     * @return List<Course>
     */
    public List<Course> findAllCou(Page page, int pageNo, int pageSize);

    /**
     * 根据学号查找所有课程
     *
     * @param sno
     * @return List<Course>
     */

    public List<Course> findCouBySno(int sno);

    /**
     * 查找该课程的学分
     *
     * @param cno
     * @return double
     */
    public double findScreByCno(int cno);

    /**
     * 根据课程号查询课程与学生
     *
     * @param cno
     * @return Set<Course>
     */
    public Set<Course> findCouStuByCno(int cno);

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
     * 根据课程号查找该课程
     */
    public Course findCouByCno(int cno);
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
     * 根据课程号1查找该课程
     */
    public List<QueryResult> findCouByCno1(int cno1);
}
