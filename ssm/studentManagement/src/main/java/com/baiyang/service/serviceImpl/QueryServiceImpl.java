/*
package com.baiyang.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.daoimpl.QueryDaoImpl;
import com.user.QueryResult;
import com.util.MybatisSessionFactory;

public class QueryServiceImpl implements QueryService{
	

	@Override
	public List<QueryResult> selectSno(int sno) {
		// TODO Auto-generated method stub
		List<QueryResult> list = null;
		SqlSession mysession=MybatisSessionFactory.getSession();
		QueryDaoImpl query=mysession.getMapper(QueryDaoImpl.class);
		list = query.selectSno(sno);
		return list;
	}

	@Override
	public List<QueryResult> selectSname(String sname) {
		// TODO Auto-generated method stub
		List<QueryResult> list = null;
		SqlSession mysession=MybatisSessionFactory.getSession();
		QueryDaoImpl query=mysession.getMapper(QueryDaoImpl.class);
		list = query.selectSname(sname);
		return list;
	}

	@Override
	public List<QueryResult> selectSclass(String sclass) {
		// TODO Auto-generated method stub
		List<QueryResult> list = null;
		SqlSession mysession=MybatisSessionFactory.getSession();
		QueryDaoImpl query=mysession.getMapper(QueryDaoImpl.class);
		list = query.selectSclass(sclass);
		return list;
	}

	@Override
	public List<QueryResult> selectCname(String cname) {
		// TODO Auto-generated method stub
		List<QueryResult> list = null;
		SqlSession mysession=MybatisSessionFactory.getSession();
		QueryDaoImpl query=mysession.getMapper(QueryDaoImpl.class);
		list = query.selectCname(cname);
		return list;
	}

	@Override
	public List<QueryResult> selectCno(int cno) {
		// TODO Auto-generated method stub
		List<QueryResult> list = null;
		SqlSession mysession=MybatisSessionFactory.getSession();
		QueryDaoImpl query=mysession.getMapper(QueryDaoImpl.class);
		list = query.selectCno(cno);
		return list;
	}

	@Override
	public List<QueryResult> selectRoom(String cclassroom) {
		// TODO Auto-generated method stub
		List<QueryResult> list = null;
		SqlSession mysession=MybatisSessionFactory.getSession();
		QueryDaoImpl query=mysession.getMapper(QueryDaoImpl.class);
		list = query.selectRoom(cclassroom);
		return list;
	}

}
*/
