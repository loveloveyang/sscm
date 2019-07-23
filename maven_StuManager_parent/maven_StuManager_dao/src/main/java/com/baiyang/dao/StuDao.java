
package com.baiyang.dao;

import com.baiyang.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository
public interface StuDao {
    /**
     * 学生登录
     *
     * @param student
     * @return Student
     */
    public Student loginStu(Student student);

    /**
     * 查找所有学生
     * @return
     */
    public List<Student> findALLStudent();

    /**
     * 查找某个学生所有课程的总学分
     * @param sno
     * @return
     */

    public double findScreBySno(int sno);

    /**
     * 模糊查询
     * @param arbitrary 任意
     * @return
     */

    public Iterator<Student> findAllByStu(String arbitrary);

    /**
     * 查找所有学生以及对应的课程
     * @return
     */

    public Set<Student> findStuCou();

    /**更新学生信息
     * @param stu
     * @return
     */

    public int updateStu(Student stu);

    /**
     * 删除学生信息
     * @param sno
     * @return
     */

    public int deleteStu(int sno);

    /**
     * 保存学生信息
     * @param stu
     * @return
     */

    public int saveStu(Student stu);

}

