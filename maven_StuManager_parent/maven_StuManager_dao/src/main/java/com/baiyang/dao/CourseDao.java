package com.baiyang.dao;

import com.baiyang.domain.Course;
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
    public List<Course> findAllCou();

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

}
