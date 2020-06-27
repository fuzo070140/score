package com.score.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MainDAOImpl implements MainDAO{
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.score.mapper.MainMapper";

	@Override
	public int select() throws Exception {
		return session.selectOne(namespace + ".Main");
	}

}
