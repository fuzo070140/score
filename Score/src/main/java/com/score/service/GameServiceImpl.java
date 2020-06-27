package com.score.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.GameVO;
import com.score.persistence.GameDAO;

@Service
public class GameServiceImpl implements GameService{
	
	@Inject
	GameDAO dao;

	@Override
	public int insert(GameVO vo) {
		return dao.insert(vo);
	}

	@Override
	public List<GameVO> list() {
		return dao.list();
	}

	@Override
	public GameVO readPage(Integer GameNumber) {
		return dao.readPage(GameNumber);
	}
	
	@Override
	public List<GameVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		 return dao.listSearch(cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}

	@Override
	public int modify(GameVO vo) {
		return dao.modify(vo);
	}

}
