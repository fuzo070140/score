package com.score.persistence;

import java.util.List;

import com.score.domain.vo.GameReplyVO;

public interface GameReplyDAO {
	
	public int insert(GameReplyVO vo);
	
	public List<GameReplyVO> replyList(Integer gameNumber,Integer gameReplyPoint);

	public int delete(Integer gameReplyNumber);
	
	public int update(Integer gameReplyNumber, String gameReplyContent);
	
	public GameReplyVO select(Integer gameReplyNumber);
}
