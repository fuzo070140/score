package com.score.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;
import com.score.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO dao;

	@Override
	public int insert(BoardVO vo) throws Exception {
		return dao.insert(vo);
	}

	@Override
	public List<BoardVO> list() {
		return dao.list();
	}

	@Transactional
	@Override
	public BoardVO readPage(Integer boardNumber) throws Exception {
		dao.boardViewCount(boardNumber);
		return dao.readPage(boardNumber);
	}

	@Override
	public int modify(BoardVO vo) {
		return dao.modify(vo);
	}

	@Override
	public int delete(Integer boardNumber) {
		return dao.delete(boardNumber);
	}
	
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		 return dao.listSearch(cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}

}
