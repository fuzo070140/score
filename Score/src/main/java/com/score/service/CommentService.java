package com.score.service;

import java.util.List;

import com.score.domain.vo.CommentVO;
import com.score.domain.vo.ReCommentVO;

public interface CommentService {
	
	public int insert(CommentVO vo) throws Exception;
	
	public List<CommentVO> commentList(Integer boardNumber,Integer commentPoint);
	
	public int delete(CommentVO vo) throws Exception;
	
	public int update(CommentVO vo) throws Exception;
	
	public int reinsert(ReCommentVO vo, int boardNumber)throws Exception;
	
	public List<ReCommentVO> reCommentList(Integer commentNumber);
	
	public int redelete(ReCommentVO vo, int boardNumber)throws Exception;
	
	public int reupdate(ReCommentVO vo);

}
