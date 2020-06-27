package com.score.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.score.domain.vo.CommentVO;
import com.score.domain.vo.ReCommentVO;
import com.score.persistence.BoardDAO;
import com.score.persistence.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Inject
	CommentDAO dao;
	
	@Inject
	BoardDAO Bdao;

	@Transactional
	@Override
	public int insert(CommentVO vo) throws Exception {
		Bdao.boardReplyCount(vo.getBoardNumber());
		return dao.insert(vo);
	}

	@Override
	public List<CommentVO> commentList(Integer boardNumber, Integer commentPoint) {
		return dao.commentList(boardNumber, commentPoint);
	}

	@Transactional
	@Override
	public int delete(CommentVO vo) throws Exception {
		Bdao.boardReplyDisCount(vo.getBoardNumber());
		return dao.delete(vo);
	}

	@Override
	public int update(CommentVO vo) throws Exception {
		Bdao.boardReplyDisCount(vo.getBoardNumber());
		return dao.update(vo);
	}

	@Transactional
	@Override
	public int reinsert(ReCommentVO vo,int boardNumber) throws Exception {
		Bdao.boardReplyCount(boardNumber);
		return dao.reinsert(vo);
	}
	
	@Override
	public List<ReCommentVO> reCommentList(Integer commentNumber) {
		return dao.reCommentList(commentNumber);
	}

	@Transactional
	@Override
	public int redelete(ReCommentVO vo, int boardNumber)throws Exception{
		Bdao.boardReplyDisCount(boardNumber);
		return dao.redelete(vo);
	}

	@Override
	public int reupdate(ReCommentVO vo) {
		return dao.reupdate(vo);
	}

}
