/*
package com.baiyang.service.serviceImpl;

import java.util.List;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.daoimpl.CouDaoImpl;
import com.vo.Course;

public class CouServiceImpl extends SqlSessionDaoSupport implements CouService{

	@Override
	public Course selectCouCno(int cno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> selectCou() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> selectCou1(int sno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCou(Course cou) {
		// TODO Auto-generated method stub
		SqlSession mysession=this.getSqlSession();
		CouDaoImpl coudao=mysession.getMapper(CouDaoImpl.class);
		mysession.commit();
		mysession.close();
		int rs =coudao.updateCou(cou);
		return rs;
	}

	@Override
	public int deleteCou(int cno) {
		// TODO Auto-generated method stub
		SqlSession mysession=MybatisSessionFactory.getSession();
		CouDaoImpl coudao=mysession.getMapper(CouDaoImpl.class);
		int rs=coudao.deleteCou(cno);
		mysession.commit();
		mysession.close();
		return rs;
	}

	@Override
	public int insertCou(Course cou) {
		// TODO Auto-generated method stub
		SqlSession mysession=MybatisSessionFactory.getSession();
		CouDaoImpl coudao=mysession.getMapper(CouDaoImpl.class);
		int rs=coudao.insertCou(cou);
		mysession.commit();
		mysession.close();
		return rs;
	}

	@Override
	public double selectScre(int cno) {
		// TODO Auto-generated method stub
		SqlSession mysession=MybatisSessionFactory.getSession();
		CouDaoImpl coudao = mysession.getMapper(CouDaoImpl.class);
		double sccredit = coudao.selectScre(cno);
		return 0;
	}

	@Override
	public Set<Course> selectCouStu(int cno) {
		// TODO Auto-generated method stub
		return null;
	}


}
*/
