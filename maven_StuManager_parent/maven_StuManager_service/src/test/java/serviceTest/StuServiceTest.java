package serviceTest;

import com.baiyang.domain.Student;
import com.baiyang.service.StuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuServiceTest {
    @Test
    public void updateStu(){
        ApplicationContext ac=
                new ClassPathXmlApplicationContext("Spring/applicationContext-service.xml","Spring/applicationContext-dao.xml");
        System.out.println("更新学生信息开始执行-----");
        Student stu=new Student();
        stu.setSno(2016591109);
        stu.setSname("乐乐");
        stu.setSpassword("123456");
        stu.setSclass("1班");
        stu.setSsex("女");
        StuService stuService=(StuService) ac.getBean("stuService");
        stuService.updateStu(stu);
        System.out.println("============================================================");
    }
    @Test
    public void savaStu(){
        ApplicationContext ac=
                new ClassPathXmlApplicationContext("Spring/applicationContext-service.xml","Spring/applicationContext-dao.xml");
        System.out.println("添加学生信息开始执行-----");
        Student stu=new Student();
        stu.setSno(2016591102);
        stu.setSname("晶晶");
        stu.setSpassword("123");
        stu.setSclass("2班");
        stu.setSsex("女");
        StuService stuService=(StuService) ac.getBean("stuService");
        stuService.savaStu(stu);
        System.out.println("============================================================");
    }
    @Test
    public void deleteStu(){
        ApplicationContext ac=
                new ClassPathXmlApplicationContext("Spring/applicationContext-service.xml","Spring/applicationContext-dao.xml");
        System.out.println("删除学生信息开始执行-----");
        Student stu=new Student();
        stu.setSno(1514010918);
        StuService stuService=(StuService) ac.getBean("stuService");
        stuService.deleteStu(stu.getSno());
        System.out.println("============================================================");
    }
}
