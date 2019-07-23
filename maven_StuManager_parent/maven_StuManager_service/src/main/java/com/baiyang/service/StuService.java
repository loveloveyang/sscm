package com.baiyang.service;


import com.baiyang.domain.Student;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 学生的业务层接口
 */
public interface StuService {
    /*public List<Student> selectStu();
    public double selectScre(int sno);
    public Student selectStu1(int id);
    public Iterator<Student> selectStu(String aa);
    public int updateStu(Student stu);
    public int deleteStu(int id);
    public int insertStu(Student stu);
    public Set<Student> selectStuCou();*/

    /**
     * @return
     */
    public List<Student> findALLStudent();

    /**
     * @param sno
     * @return
     */

    public double findScreBySno(int sno);

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
     * @param stu
     * @return
     */

    public int updateStu(Student stu);

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
