package testdao;

import com.baiyang.dao.StuDao;
import com.baiyang.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Set;

public class StuDaoTest {
    @Test
    public void loginStu(){
        System.out.println("登录方法测试");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StuDao stuDao=(StuDao) ac.getBean("stuDao");
        Student student=new Student();
        student.setSno(1);
        student.setSpassword("0");
        Student stu = stuDao.loginStu(student);
        System.out.println(stu);
    }
    @Test
    public void findALLStudent(){
        System.out.println("查找所有学生测试");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StuDao stuDao=(StuDao) ac.getBean("stuDao");
        List<Student> student = stuDao.findALLStudent();
        for (Student s:student){
            System.out.println(s);
        }
    }
    @Test
    public void findScreBySno(){
        System.out.println("查找某个学生的总学分测试");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StuDao stuDao=(StuDao) ac.getBean("stuDao");
        double screBySno = stuDao.findScreBySno(1);
        System.out.println(screBySno);
    }
    @Test
    public void findStuCou(){
        System.out.println("查找所有学生以及课程");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StuDao stuDao=(StuDao) ac.getBean("stuDao");
        Set<Student> stuCou = stuDao.findStuCou();
        for (Student s:stuCou) {
            System.out.println(s);
        }
    }
    @Test
    public void updateStu(){
        System.out.println("更新学生");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StuDao stuDao=(StuDao) ac.getBean("stuDao");
        Student student=new Student();
        student.setSno(2016591110);
        student.setSname("贝贝");
        student.setSclass("1班");
        student.setSsex("女");
        student.setSpassword("132456");
        int i = stuDao.updateStu(student);
        System.out.println("更新学生"+i);

    }
    @Test
    public void saveStu(){
        System.out.println("添加学生");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StuDao stuDao=(StuDao) ac.getBean("stuDao");
        Student student=new Student();
        student.setSno(2016591111);
        student.setSname("雨音");
        student.setSpassword("123");
        student.setSsex("女");
        student.setSclass("1班");
        Student student1=new Student();
        student1.setSno(2016591112);
        student1.setSname("初音");
        student1.setSpassword("123");
        student1.setSsex("女");
        student1.setSclass("1班");
        int i = stuDao.saveStu(student1);
        System.out.println("添加学生"+i);
    }
    @Test
    public void deleteStu(){
        System.out.println("删除学生");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StuDao stuDao=(StuDao) ac.getBean("stuDao");
        int i = stuDao.deleteStu(2016591112);
        System.out.println("删除学生"+i);
    }

}
