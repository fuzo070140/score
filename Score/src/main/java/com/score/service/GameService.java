package com.score.service;

import java.util.List;

import com.score.domain.dto.ReviewCriteria;
import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;
import com.score.domain.vo.GameVO;

public interface GameService {
	
	public int insert(GameVO vo);
	
	public List<GameVO> list();
	
	public GameVO readPage(Integer GameNumber);
	
	public List<GameVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public int modify(GameVO vo);

}
