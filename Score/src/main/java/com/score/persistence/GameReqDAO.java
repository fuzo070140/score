package com.score.persistence;

import com.score.domain.vo.GameReqVO;

public interface GameReqDAO {
	
	public int insert(GameReqVO vo)throws Exception;

}
