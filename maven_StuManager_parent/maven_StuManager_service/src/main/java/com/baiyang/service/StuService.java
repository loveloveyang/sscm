package com.baiyang.service;


import com.baiyang.domain.Student;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 学生的业务层接口
 */
public interface StuService {
    /**
     * @return
     */

    public List<Student> findALLStudent();

    /**
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
     * @param sno
     * @return
     */

    public int deleteStu(int sno);

    /**
     * @param stu
     * @return
     */

    public int savaStu(Student stu);


}
