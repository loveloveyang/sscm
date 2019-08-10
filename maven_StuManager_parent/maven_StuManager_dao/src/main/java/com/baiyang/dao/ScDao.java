package com.baiyang.dao;

import com.baiyang.domain.Course;
import com.baiyang.domain.Sc;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScDao {
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
    public int delectSc(@Param("sno") int sno, @Param("cno") int cno);

    /**
     * 添加选课关系
     *
     * @param sc
     * @return
     */
    public int saveSc(Sc[] sc);

    /**
     * 根据学号添加选课与学生的关系
     *
     * @param sno
     * @return
     */
    public int saveScBySnoCno(@Param("sno")int sno, @Param("cno")int cno);

    /**
     * 根据课程号删除选课与学生的关系
     *
     * @param cno
     * @return
     */
    public int delectScByCno(int cno);

    /**
     * 根据学号删除选课与学生的关系
     *
     * @param cno
     * @return
     */
    public int delectScBySno(int cno);
}
