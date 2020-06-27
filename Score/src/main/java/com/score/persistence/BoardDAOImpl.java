package com.score.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.score.mapper.BoardMapper";

	@Override
	public int insert(BoardVO vo) {
		return session.insert(namespace + ".insert", vo);
	}


	@Override
	public List<BoardVO> list() {
		return session.selectList(namespace +".list");
	}


	@Override
	public BoardVO readPage(Integer boardNumber) {
		return session.selectOne(namespace +".readPage", boardNumber);
	}


	@Override
	public int modify(BoardVO vo) {
		return session.update(namespace + ".modify", vo);
	}

	@Override
	public int delete(Integer boardNumber) {
		return session.delete(namespace + ".delete", boardNumber);
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		
		 return session.selectList(namespace + ".listSearch", cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne(namespace + ".listSearchCount", cri);
	}


	@Override
	public int boardViewCount(Integer boardNumber) throws Exception {
		return session.update(namespace + ".boardViewCount", boardNumber);
	}


	@Override
	public int boardReplyCount(Integer boardNumber) throws Exception {
		return session.update(namespace + ".boardReplyCount", boardNumber);
	}


	@Override
	public int boardReplyDisCount(Integer boardNumber) throws Exception {
		return session.update(namespace + ".boardReplyDisCount", boardNumber);
	}

}
