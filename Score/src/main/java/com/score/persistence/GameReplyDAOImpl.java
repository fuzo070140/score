package com.score.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.score.domain.vo.GameReplyVO;

@Repository
public class GameReplyDAOImpl implements GameReplyDAO {
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.score.mapper.GameReplyMapper";

	@Override
	public int insert(GameReplyVO vo) {
		return session.insert(namespace + ".insert", vo);
	}

	@Override
	public List<GameReplyVO> replyList(Integer gameNumber, Integer gameReplyPoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gameNumber", gameNumber);
		map.put("gameReplyPoint", gameReplyPoint);
		return session.selectList(namespace + ".replyList", map);
	}

	@Override
	public int delete(Integer gameReplyNumber) {
		return session.delete(namespace + ".replyDelete", gameReplyNumber);
	}

	@Override
	public int update(Integer gameReplyNumber, String gameReplyContent) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gameReplyNumber", gameReplyNumber);
		map.put("gameReplyContent", gameReplyContent);
		return session.update(namespace + ".replyUpdate", map);
	}

	@Override
	public GameReplyVO select(Integer gameReplyNumber) {
		return session.selectOne(namespace + ".replySelect", gameReplyNumber);
	}

}
