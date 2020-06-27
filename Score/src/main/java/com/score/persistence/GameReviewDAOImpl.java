package com.score.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.score.domain.vo.GameReviewVO;
import com.score.domain.vo.GameVO;

@Repository
public class GameReviewDAOImpl implements GameReviewDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.score.mapper.GameReviewMapper";

	@Override
	public int insert(GameReviewVO vo) {
		return session.insert(namespace + ".insert", vo);
	}

	@Override
	public List<GameReviewVO> select(Integer gameNumber) {
		return session.selectList(namespace + ".list", gameNumber);
	}
	@Override
	public int update(GameReviewVO vo) {
		return session.update(namespace + ".update", vo);
	}

	@Override
	public int delete(Integer gameReviewNumber) {
		return session.delete(namespace + ".delete", gameReviewNumber);
	}

	@Override
	public GameVO selectGame(Integer gameNumber) {
		return session.selectOne(namespace + ".selectGame", gameNumber);
	}

	@Override
	public List<GameReviewVO> selectReviewList(Integer gameNumber) {
		System.out.println(gameNumber);
		return session.selectList(namespace + ".selectReviewList", gameNumber);
	}

}
