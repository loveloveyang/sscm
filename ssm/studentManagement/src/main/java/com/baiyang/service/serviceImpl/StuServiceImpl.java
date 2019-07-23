package com.baiyang.service.serviceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.baiyang.dao.StuDao;
import com.baiyang.domain.Student;
import com.baiyang.service.StuService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("stuService")
public class StuServiceImpl implements StuService {
    @Autowired
    private StuDao stuDao;
	@Override
	public List<Student> selectStu() {
        System.out.println("业务层：查询学生的方法实现了");
		return stuDao.selectStu();
	}

	/*@Override
	public double selectScre(int sno) {
		// TODO Auto-generated method stub
		SqlSession mysession = MybatisSessionFactory.getSession();
		StuDaoImpl studao = mysession.getMapper(StuDaoImpl.class);
		double sccredit = studao.selectScre(sno);
		return sccredit;
	}

	@Override
	public Student selectStu1(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Student> selectStu(String aa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStu(Student stu) {
		// TODO Auto-generated method stub
		SqlSession mysession=MybatisSessionFactory.getSession();
		StuDaoImpl studao=mysession.getMapper(StuDaoImpl.class);
		int rs =studao.updateStu(stu);
		mysession.commit();
		mysession.close();
		return rs;
	}

	@Override
	public int deleteStu(int id) {
		// TODO Auto-generated method stub
		SqlSession mysession = MybatisSessionFactory.getSession();
		StuDaoImpl studao = mysession.getMapper(StuDaoImpl.class);
		int rs = studao.deleteStu(id);
		mysession.commit();
		mysession.close();
		return rs;
	}

	@Override
	public int insertStu(Student stu) {
		// TODO Auto-generated method stub
		SqlSession mysession=MybatisSessionFactory.getSession();
		StuDaoImpl studao=mysession.getMapper(StuDaoImpl.class);
		int rs=studao.insertStu(stu);
		mysession.commit();
		mysession.close();
		return rs;
	}

	@Override
	public Set<Student> selectStuCou() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	

}
