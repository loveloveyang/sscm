
package com.baiyang.dao;

import java.util.Iterator;

import java.util.List;
import java.util.Set;

import com.baiyang.domain.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface StuDao {
    @Select("SELECT * FROM student WHERE SNo=#{sno} AND Spassword=#{spassword}")
    public Student loginStu(Student student);
    @Select("SELECT * FROM student ")
    public List<Student> selectStu();

    public double selectScre(int sno);

    public Student selectStu1(int id);

    public Iterator<Student> selectStu(String aa);

    public int updateStu(Student stu);

    public int deleteStu(int id);

    public int insertStu(Student stu);

    public Set<Student> selectStuCou();

}

