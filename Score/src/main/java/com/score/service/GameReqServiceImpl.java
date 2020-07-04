package com.score.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.score.domain.vo.GameReqVO;
import com.score.persistence.GameReqDAO;

@Service
public class GameReqServiceImpl implements GameReqService {
	
	@Inject
	GameReqDAO dao;

	@Override
	public int insert(GameReqVO vo) throws Exception {
		return dao.insert(vo);
	}

}
