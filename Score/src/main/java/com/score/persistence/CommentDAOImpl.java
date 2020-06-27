package com.score.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;
import com.score.domain.vo.CommentVO;
import com.score.domain.vo.ReCommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO{
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.score.mapper.CommentMapper";

	@Override
	public int insert(CommentVO vo) {
		return session.insert(namespace + ".insert", vo);
	}

	@Override
	public List<CommentVO> commentList(Integer boardNumber, Integer commentPoint) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNumber", boardNumber);
		map.put("commentPoint", commentPoint);
		return session.selectList(namespace + ".commentList", map);
	}

	@Override
	public int delete(CommentVO vo) {
		return session.delete(namespace + ".delete", vo.getCommentNumber());
	}

	@Override
	public int update(CommentVO vo) {
		return session.update(namespace + ".update", vo);
	}

	@Override
	public int reinsert(ReCommentVO vo) {
		return session.insert(namespace + ".reinsert", vo);
	}

	@Override
	public List<ReCommentVO> reCommentList(Integer commentNumber) {
		return session.selectList(namespace + ".reCommentList", commentNumber);
	}

	@Override
	public int redelete(ReCommentVO vo) {
		return session.delete(namespace + ".redelete", vo.getReCommentNumber());
	}

	@Override
	public int reupdate(ReCommentVO vo) {
		return session.update(namespace + ".reupdate", vo);
	}


}
