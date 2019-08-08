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
     * 打印所有学生
     * @return
     */

    public List<Student> findALLStudent(Page page, int pageNo, int pageSize);

    /**
     * 查找学生选课的总学分
     * @param sno
     * @return
     */

    public Student findScreBySno(int sno);

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
     * @param student
     * @return
     */

    public int updateStu(Student student);

    /**
     * 学生修改密码
     * @param sno
     * @param newPassword
     * @return
     */
    public int updateStuPass(int sno,String newPassword);
    /**
     * @param sno
     * @return
     */
    public int deleteStu(int sno);

    /**
     * @param stu
     * @return
     */

    public int savaStu(Student stu);

    // 学生查询 start
    public List<QueryResult> findStuBySno1(int sno1);

    public List<QueryResult> findStuBySname(String sname);

    public List<QueryResult> findStuBySclass(String sclass);

    public List<QueryResult> findStuBySsex(String ssex);

    public List<QueryResult> findScreBySno1(int sno1);
    // 学生查询 end


}
