package testdao;


import com.baiyang.dao.ScDao;
import com.baiyang.domain.Course;
import com.baiyang.domain.Sc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ScDaoTest {
    /**
     * 查询某个学生选的课
     *
     * @return
     */

    @Test
    public void findScBySno() {
        System.out.println("查询某个学生选的课测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        Sc sc = new Sc();
        sc.setSno(1);
        ScDao scDao = (ScDao) ac.getBean("scDao");
        List<Course> scBySno = scDao.findScBySno(sc.getSno());
        for (Course c : scBySno
        ) {
            System.out.println(c);
        }
        System.out.println("==========================================================================");
    }

    /**
     * 根据学号和课程号共同删除选课与学生的关系
     *
     * @return
     */

    @Test
    public void delectSc() {
        System.out.println("删除选课关系测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        Sc sc = new Sc();
        sc.setSno(1);
        sc.setCno(1);
        ScDao scDao = (ScDao) ac.getBean("scDao");
        int i = scDao.delectSc(sc.getSno(), sc.getCno());
        System.out.println("删除选课关系成功");
        System.out.println("==========================================================================");
    }

    /**
     * 添加选课关系
     *
     * @return
     */

    @Test
    public void saveSc() {
        System.out.println("添加选课关系测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        Sc[] sc =new Sc[1];
        sc[0]=new Sc();
        sc[0].setCno(1);
        sc[0].setSno(1);

        ScDao scDao = (ScDao) ac.getBean("scDao");
        int i = scDao.saveSc(sc);
        System.out.println("添加选课关系成功"+i);
        System.out.println("==========================================================================");
    }

}
