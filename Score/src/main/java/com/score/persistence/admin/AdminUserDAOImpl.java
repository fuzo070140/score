package com.score.persistence.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.score.domain.admin.vo.AdminUserVO;

@Repository
public class AdminUserDAOImpl implements AdminUserDAO {
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.score.mapper.AdminUserMapper";

	@Override
	public AdminUserVO adminLogin(AdminUserVO vo) throws Exception {
		return session.selectOne(namespace+".adminLogin", vo);
	}

}
