package com.score.persistence;

import java.util.List;

import com.score.domain.vo.GameReviewVO;
import com.score.domain.vo.GameVO;

public interface GameReviewDAO {
	
	public int insert(GameReviewVO vo);

	public List<GameReviewVO> select(Integer gameNumber);
	
	public int update(GameReviewVO vo);
	
	public int delete(Integer gameReviewNumber);
	
	public GameVO selectGame(Integer gameNumber);
	
	public List<GameReviewVO> selectReviewList(Integer gameNumber);
	
}
