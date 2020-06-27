package com.score.service;

import java.util.List;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;

public interface BoardService {
	
	public int insert(BoardVO vo) throws Exception;

	public List<BoardVO> list();
	
	public BoardVO readPage(Integer boardNumber) throws Exception;
	
	public int modify(BoardVO vo);
	
	public int delete(Integer boardNumber);
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}
