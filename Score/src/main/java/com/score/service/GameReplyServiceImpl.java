package com.score.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.score.domain.vo.GameReplyVO;
import com.score.persistence.GameReplyDAO;

@Service
public class GameReplyServiceImpl implements GameReplyService{
	
	@Inject
	GameReplyDAO dao;

	@Override
	public int insert(GameReplyVO vo) {
		return dao.insert(vo);
	}

	@Override
	public List<GameReplyVO> replyList(Integer gameNumber, Integer gameReplyPoint) {
		return dao.replyList(gameNumber, gameReplyPoint);
	}

	@Override
	public int delete(Integer gameReplyNumber) {
		return dao.delete(gameReplyNumber);
	}

	@Transactional
	@Override
	public GameReplyVO update(Integer gameReplyNumber, String gameReplyContent) {
		dao.update(gameReplyNumber, gameReplyContent);
		return dao.select(gameReplyNumber);
	}

	@Override
	public GameReplyVO select(Integer gameReplyNumber) {
		return dao.select(gameReplyNumber);
	}

}
