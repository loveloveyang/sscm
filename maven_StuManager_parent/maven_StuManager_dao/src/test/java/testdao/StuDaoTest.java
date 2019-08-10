package testdao;

import com.baiyang.dao.StudentDao;
import com.baiyang.domain.Student;
import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;
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
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
        Student student=new Student();
        student.setSno(1);
        student.setSpassword("0");
        Student stu = studentDao.loginStu(student);
        System.out.println(stu);
        System.out.println("==========================================================================");

    }
    @Test
    public void findALLStudent(){
        System.out.println("查找所有学生测试");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
        List<Student> student = studentDao.findALLStudent(0,10);
        for (Student s:student){
            System.out.println(s);
        }
        System.out.println("==========================================================================");

    }
    @Test
    public void findScreBySno(){
        System.out.println("查找某个学生的总学分测试");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
        Double student = studentDao.findScreBySno(2016591102);
        System.out.println(student);
        //System.out.println("学号是："+student.getSno()+"该学生的总学分"+student.getScredit());
        System.out.println("==========================================================================");

    }
    @Test
    public void findStuCou(){
        System.out.println("查找所有学生以及课程");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
        Set<Student> stuCou = studentDao.findStuCou();
        for (Student s:stuCou) {
            System.out.println(s);
        }
        System.out.println("==========================================================================");

    }
    @Test
    public void updateStu(){
        System.out.println("更新学生");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
        Student student=new Student();
        student.setSno(1514010919);
        student.setSname("大宝");
        student.setSclass("5班");
        student.setSsex("男");
        student.setSpassword("123");
        int i = studentDao.updateStu(student);
        System.out.println("更新学生"+i);
        System.out.println("==========================================================================");

    }
    @Test
    public void saveStu(){
        System.out.println("添加学生");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
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
        int i = studentDao.saveStu(student1);
        System.out.println("添加学生"+i);
        System.out.println("==========================================================================");

    }
    @Test
    public void deleteStu(){
        System.out.println("删除学生");
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
        int i = studentDao.deleteStu(2016591112);
        System.out.println("删除学生"+i);
        System.out.println("==========================================================================");

    }
    @Test
    public void findStuBySno(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        StudentDao studentDao =(StudentDao) ac.getBean("studentDao");
        Student student=new Student();
        student.setSno(1514010918);
        Student stu = studentDao.findStuBySno(student.getSno());
        System.out.println(stu);
    }
}
