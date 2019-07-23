/*
package com.baiyang.service.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.daoimpl.ScDaoImpl;
import com.util.MybatisSessionFactory;
import com.vo.Course;
import com.vo.Sc;

public class ScServiceImpl implements ScService{

	@Override
	public List<Course> selectSc(int sno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delectSc(int sno, int cno) {
		// TODO Auto-generated method stub
		SqlSession mysession = MybatisSessionFactory.getSession();
		ScDaoImpl scdao = mysession.getMapper(ScDaoImpl.class);
		int rs = scdao.delectSc(sno,cno);
		mysession.commit();
		mysession.close();
		return rs;
	}

	@Override
	public int insertSc(Sc[] sc) {
		// TODO Auto-generated method stub
		SqlSession mysession=MybatisSessionFactory.getSession();
		ScDaoImpl scdao = mysession.getMapper(ScDaoImpl.class);
		int rs = scdao.insertSc(sc);
		mysession.commit();
		mysession.close();
		return rs;
	}



}
*/
