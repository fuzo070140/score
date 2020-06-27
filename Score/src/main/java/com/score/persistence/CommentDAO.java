package com.score.persistence;

import java.util.List;

import com.score.domain.vo.CommentVO;
import com.score.domain.vo.ReCommentVO;

public interface CommentDAO {
	
	public int insert(CommentVO vo);
	
	public List<CommentVO> commentList(Integer boardNumber,Integer commentPoint);

	public int delete(CommentVO vo);
	
	public int update(CommentVO vo);
	
	public int reinsert(ReCommentVO vo);
	
	public List<ReCommentVO> reCommentList(Integer commentNumber);
	
	public int redelete(ReCommentVO vo);
	
	public int reupdate(ReCommentVO vo);
}
