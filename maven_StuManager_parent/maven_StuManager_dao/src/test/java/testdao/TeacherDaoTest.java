package testdao;

import com.baiyang.dao.TeacherDao;
import com.baiyang.domain.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeacherDaoTest {
    /**
     * 老师登录
     *
     * @return
     */
    @Test
    public void loginTea() {
        System.out.println("登录方法测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/applicationContext-dao.xml");
        Teacher teacher=new Teacher();
        teacher.setTno(1);
        teacher.setTpassword("1");
        TeacherDao teacherDao = (TeacherDao) ac.getBean("teacherDao");
        Teacher teacher1 = teacherDao.loginTea(teacher);
        System.out.println(teacher1);
        System.out.println("==========================================================================");

    }
}
