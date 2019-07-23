package testdao;

import com.baiyang.dao.CourseDao;
import com.baiyang.domain.Course;
import com.baiyang.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Set;

public class CourseDaoTest {
    /**
     * 根据课程号查找所有课程
     */
    @Test
    public void findAllCouByCno() {
        System.out.println("根据课程号查找所有课程测试");
        Course course = new Course();
        course.setCno(1);
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        List<Course> allCouByCno = courseDao.findAllCouByCno(course.getCno());
        for (Course c:allCouByCno
             ) {
            System.out.println(c);
        }
        System.out.println("==========================================================================");
    }

    /**
     * 查找所有课程
     *
     * @return List<Course>
     */
    @Test
    public void findAllCou() {
        System.out.println("查找所有课程测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        List<Course> allCou = courseDao.findAllCou();
        for (Course cou : allCou
        ) {
            System.out.println(cou);

        }
        System.out.println("==========================================================================");
    }

    /**
     * 根据学号查找所有课程
     *
     * @return List<Course>
     */

    @Test
    public void findCouBySno() {
        System.out.println("根据学号查找所有课程测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        Student studet = new Student();
        studet.setSno(1);
        List<Course> couBySno = courseDao.findCouBySno(studet.getSno());
        for (Course cou : couBySno
        ) {
            System.out.println(cou);
        }
        System.out.println("==========================================================================");
    }

    /**
     * 查找该课程的学分
     *
     * @return double
     */
    @Test
    public void findScreByCno() {
        System.out.println("查找该课程的学分测试");
        Course course = new Course();
        course.setCno(1);
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        double screByCno = courseDao.findScreByCno(course.getCno());
        System.out.println("该课程的学分是"+screByCno);
        System.out.println("==========================================================================");
    }

    /**
     * 根据课程号查询课程与学生
     *
     * @return Set<Course>
     */
    @Test
    public void findCouStuByCno() {
        System.out.println("根据课程号查询课程与学生程测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        Course course = new Course();
        course.setCno(1);
        Set<Course> couStuByCno = courseDao.findCouStuByCno(course.getCno());
        for (Course cou : couStuByCno
        ) {
            System.out.println(cou);

        }
        System.out.println("==========================================================================");
    }

    /**
     * 更新课程
     *
     * @return int
     */
    @Test
    public void updateCou() {
        System.out.println("更新课程");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        Course course = new Course();
        course.setCno(12);
        course.setCname("jsp程序设计");
        course.setCcredit(2.5);
        course.setCclassroom("301教室");
        int i = courseDao.updateCou(course);
        System.out.println("课程更新成功" + i);
        System.out.println("==========================================================================");
    }

    /**
     * 添加课程
     *
     * @return int
     */

    @Test
    public void saveCou() {
        System.out.println("添加课程");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        Course course = new Course();
        //加入的学号无用，但是能添加成功，学号自增长。
        course.setCno(13);
        course.setCname("大数据课程");
        course.setCcredit(3.5);
        course.setCclassroom("302教室");
        int i = courseDao.saveCou(course);
        System.out.println("添加课程成功" + i);
        System.out.println("==========================================================================");

    }

    /**
     * 删除课程
     *
     * @return int
     */
    @Test
    public void deleteCou() {
        System.out.println("删除课程");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        CourseDao courseDao = (CourseDao) ac.getBean("courseDao");
        Course course = new Course();
        course.setCno(19);
        int i = courseDao.deleteCou(course.getCno());
        System.out.println("删除课程成功" + i);
        System.out.println("==========================================================================");

    }
}
