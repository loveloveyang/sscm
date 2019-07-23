package com.baiyang.service.impl;

import com.baiyang.domain.Student;
import com.baiyang.service.StuService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Service("stuService")
public class StuServiceImpl implements StuService {
	@Override
	public List<Student> findALLStudent() {
		System.out.println("查找所有学生的方法开始执行");
		return null;
	}

	@Override
	public double findScreBySno(int sno) {
		System.out.println("查找某个学生的总学分开始执行");
		return 0;
	}

	@Override
	public Iterator<Student> findAllByStu(String all) {
		return null;
	}

	@Override
	public Set<Student> findStuCou() {
		return null;
	}

	@Override
	public int updateStu(Student stu) {
		return 0;
	}

	@Override
	public int deleteStu(int sno) {
		return 0;
	}

	@Override
	public int savaStu(Student stu) {
		return 0;
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
