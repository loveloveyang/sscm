
package com.baiyang.dao;

import com.baiyang.domain.QueryResult;
import com.baiyang.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository
public interface StudentDao {
    /**
     * 学生登录
     *
     * @param student
     * @return Student
     */
    public Student loginStu(Student student);

    /**
     * 查找所有学生
     *
     * @return
     */
    public List<Student> findALLStudent(@Param("startNum") int startNum, @Param("endNum")int endNum);

    /**
     * 查询学生记录数
     * @return
     */
    public int findStuCount();

    /**
     * 根据学号查找该学生（更新学生用）
     */
    public Student findStuBySno(int sno);


    /**
     * 查找所有学生以及对应的课程
     *
     * @return
     */

    public Set<Student> findStuCou();

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */

    public int updateStu(Student student);

    /**
     * 更改学生密码
     * @param sno
     * @param newPassword
     * @return
     */
    public int updateStuPass(@Param("sno") int sno,@Param("newPassword") String newPassword);
    /**
     * 删除学生信息
     *
     * @param sno
     * @return
     */

    public int deleteStu(int sno);

    /**
     * 保存学生信息
     *
     * @param stu
     * @return
     */

    public int saveStu(Student stu);

    /**
     * 查找某个学生所有课程的总学分
     *
     * @param sno
     * @return
     */

    public Student findScreBySno(int sno);

    // 学生查询 start
    public List<QueryResult> findStuBySno1(int sno1);

    public List<QueryResult> findStuBySname(String sname);

    public List<QueryResult> findStuBySclass(String sclass);

    public List<QueryResult> findStuBySsex(String ssex);

    public List<QueryResult> findScreBySno1(int sno1);
    // 学生查询 end

}

