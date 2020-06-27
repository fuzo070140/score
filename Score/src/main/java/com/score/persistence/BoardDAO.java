package com.score.persistence;

import java.util.List;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;

public interface BoardDAO {

	public int insert(BoardVO vo);

	public List<BoardVO> list();

	public BoardVO readPage(Integer boardNumber);

	public int modify(BoardVO vo);

	public int delete(Integer boardNumber);

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public int boardViewCount(Integer boardNumber)throws Exception;

	public int boardReplyCount(Integer boardNumber)throws Exception;

	public int boardReplyDisCount(Integer boardNumber)throws Exception;
}
