package com.baiyang.service;


import com.baiyang.domain.Page;
import com.baiyang.domain.QueryResult;
import com.baiyang.domain.Student;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 学生的业务层接口
 */
public interface StuService {
    /**
     * 查找所有选课学生
     *
     * @return
     */

    public List<Student> findALLStudent(Page page, int pageNo, int pageSize);

    /**
     * 查找所有学生
     *
     * @return
     */

    public List<Student> findALLStudent1(Page page, int pageNo, int pageSize);

    /**
     * 老师查找所有选课学生，并且记录最低学分
     *
     * @return
     */

    public List<Student> findALLStudent2(Page page, int pageNo, int pageSize, float minScredit);

    /**
     * 查找学生选课的总学分
     *
     * @param sno
     * @return
     */

    public Double findScreBySno(int sno);

    /**
     * 根据学号查找该学生（更新学生用）
     */

    public Student findStuBySno(int sno);

    /**
     * @param all
     * @return
     */

    public Iterator<Student> findAllByStu(String all);

    /**
     * @return
     */

    public Set<Student> findStuCou();

    /**
     * 老师更新学生
     *
     * @param student
     * @return
     */

    public int updateStu(Student student);

    /**
     * 学生修改密码
     *
     * @param sno
     * @param newPassword
     * @return
     */
    public int updateStuPass(int sno, String newPassword);

    /**
     * 老师删除学生
     *
     * @param sno
     * @return
     */
    public int deleteStu(int sno);

    /**
     * 老师添加学生
     *
     * @param stu
     * @return
     */

    public int savaStu(Student stu);

    // 老师查询学生 start
    public List<QueryResult> findStuBySno1(int sno1);

    public List<QueryResult> findStuBySname(String sname);

    public List<QueryResult> findStuBySclass(String sclass);

    public List<QueryResult> findStuBySsex(String ssex);


    // 老师查询学生 end

    // 管理员查询学生 start
    public List<QueryResult> findStuBySno2(int sno2);

    public List<QueryResult> findStuBySname2(String sname);

    public List<QueryResult> findStuBySclass2(String sclass);

    public List<QueryResult> findStuBySsex2(String ssex);


    // 管理员查询学生 end


}
