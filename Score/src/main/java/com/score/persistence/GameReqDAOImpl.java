package com.score.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.score.domain.vo.GameReqVO;

@Repository
public class GameReqDAOImpl implements GameReqDAO {
	
	@Autowired
	private SqlSession session;

	private static String namespace = "com.score.mapper.GameReqMapper";

	@Override
	public int insert(GameReqVO vo) throws Exception {
		return session.insert(namespace+".insert", vo);
	}

}
