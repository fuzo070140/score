package com.score.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;
import com.score.domain.vo.GameReviewVO;
import com.score.domain.vo.GameVO;
import com.score.persistence.BoardDAO;
import com.score.persistence.GameDAO;
import com.score.persistence.GameReviewDAO;

@Service
public class GameReviewServiceImpl implements GameReveiwService {

	@Inject
	GameReviewDAO dao;
	
	@Inject
	GameDAO Gdao;
	
	@Transactional
	@Override
	public int insert(GameReviewVO vo) {
		int re = dao.insert(vo);
		Gdao.gameScoreNumberOfPCount(vo.getGameNumber());
		Gdao.gameScoreUpdate(vo.getGameNumber(), vo.getGameScore());
		Gdao.gameAvgScoreUpdate(vo.getGameNumber());
		return re;
	}

	@Override
	public List<GameReviewVO> select(Integer gameNumber) {
		return dao.select(gameNumber);
	}

	@Override
	public int update(GameReviewVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(Integer gameReviewNumber) {
		return dao.delete(gameReviewNumber);
	}

	@Override
	public GameVO selectGame(Integer gameNumber) {
		return dao.selectGame(gameNumber);
	}

	@Override
	public List<GameReviewVO> selectReviewList(Integer gameNumber) {
		return dao.selectReviewList(gameNumber);
	}

}
