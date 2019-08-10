package testdao;

import com.baiyang.dao.QueryDao;
import com.baiyang.domain.Course;
import com.baiyang.domain.QueryResult;
import com.baiyang.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class QueryDaoTest {

    @Test
    public void findAllBySno(){
        System.out.println("findAllBySno开始测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        QueryDao courseDao = (QueryDao) ac.getBean("queryDao");
        Student student=new Student();
        student.setSno(1);
        List<QueryResult> allBySno = courseDao.findAllBySno(student.getSno());
        for (QueryResult q:allBySno
             ) {
            System.out.println(q);
        }
        System.out.println("==========================================================================");
    }
    @Test
    public void findAllBySname(){
        System.out.println("findAllBySname开始测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        QueryDao courseDao = (QueryDao) ac.getBean("queryDao");
        Student student=new Student();
       student.setSname("呆呆");
        List<QueryResult> allBySno = courseDao.findAllBySname(student.getSname());
        for (QueryResult q:allBySno
        ) {
            System.out.println(q);
        }
        System.out.println("==========================================================================");
    }
    @Test
    public void findAllBySclass(){
        System.out.println("findAllBySclass开始测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        QueryDao courseDao = (QueryDao) ac.getBean("queryDao");
        Student student=new Student();
       student.setSclass("1班");
        List<QueryResult> allBySno = courseDao.findAllBySclass(student.getSclass());
        for (QueryResult q:allBySno
        ) {
            System.out.println(q);
        }
        System.out.println("==========================================================================");
    }
    @Test
    public void findAllByCname(){
        System.out.println("findAllByCname开始测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        QueryDao courseDao = (QueryDao) ac.getBean("queryDao");
        Course course=new Course();
        course.setCname("大学英语");
        List<QueryResult> allBySno = courseDao.findAllByCname(course.getCname());
        for (QueryResult q:allBySno
        ) {
            System.out.println(q);
        }
        System.out.println("==========================================================================");
    }
    @Test
    public void findAllByCno(){
        System.out.println("findAllByCno开始测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        QueryDao courseDao = (QueryDao) ac.getBean("queryDao");
        Course course=new Course();
        course.setCno(1);
        List<QueryResult> allBySno = courseDao.findAllByCno(course.getCno());
        for (QueryResult q:allBySno
        ) {
            System.out.println(q);
        }
        System.out.println("==========================================================================");
    }
    @Test
    public void findAllByRoom(){
        System.out.println("findAllByRoom开始测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        QueryDao courseDao = (QueryDao) ac.getBean("queryDao");
        Course course=new Course();
        course.setCclassroom("201教室");
        List<QueryResult> allBySno = courseDao.findAllByRoom(course.getCclassroom());
        for (QueryResult q:allBySno
        ) {
            System.out.println(q);
        }
        System.out.println("==========================================================================");
    }
}
