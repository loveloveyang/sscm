package com.baiyang.service;


import com.baiyang.domain.Course;
import com.baiyang.domain.Sc;

import java.util.List;

public interface ScService {
    /**
     * 查询某个学生选的课
     *
     * @param sno
     * @return
     */
    public List<Course> findScBySno(int sno);

    /**
     * 根据学号和课程号共同删除选课与学生的关系
     *
     * @param sno
     * @param cno
     * @return
     */
    public int delectSc(int sno, int cno);

    /**
     * 添加选课关系
     *
     * @param sc
     * @return
     */
    public int saveSc(Sc[] sc);

    /**
     * 通过学号课程号添加选课关系
     *
     * @param sno
     * @param cno
     * @return
     */
    public int saveScBySnoCno(int sno, int cno);

}
