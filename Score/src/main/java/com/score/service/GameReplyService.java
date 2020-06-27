package com.score.service;

import java.util.List;

import com.score.domain.vo.GameReplyVO;

public interface GameReplyService {
	
	public int insert(GameReplyVO vo);
	
	public List<GameReplyVO> replyList(Integer gameNumber,Integer gameReplyPoint);

	public int delete(Integer gameReplyNumber);
	
	public GameReplyVO update(Integer gameReplyNumber, String gameReplyContent);
	
	public GameReplyVO select(Integer gameReplyNumber);
}
