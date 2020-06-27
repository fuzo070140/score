package com.score.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.score.domain.vo.CommentVO;
import com.score.domain.vo.ReCommentVO;
import com.score.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Inject
	CommentService service;

	@RequestMapping(value = "/list/{boradNumber}/{commentPoint}", method = RequestMethod.GET)
	public ResponseEntity<List<CommentVO>> list(@PathVariable("boradNumber") Integer boardNumber,
			@PathVariable("commentPoint") Integer commentPoint) {
		ResponseEntity<List<CommentVO>> entity = null;
		List<CommentVO> Lvo = new ArrayList<CommentVO>();
		for(int i = 0; i > Lvo.size(); i++){
			
		}
		try {
			entity = new ResponseEntity<>(service.commentList(boardNumber, commentPoint), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 댓글작성
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insertPOST(@RequestBody CommentVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.insert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	// 댓글삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> deletePOST(@RequestBody CommentVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.delete(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	// 댓글수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> updatePOST(@RequestBody CommentVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.update(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	// 답글작성
	@RequestMapping(value = "/reinsert/{boardNumber}", method = RequestMethod.POST)
	public ResponseEntity<String> reinsertPOST(@PathVariable("boardNumber") Integer boardNumber,@RequestBody ReCommentVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.reinsert(vo, boardNumber);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	// 답글리스트                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	@RequestMapping(value = "/relist/{commentNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<ReCommentVO>> relist(@PathVariable("commentNumber") Integer commentNumber) {
		ResponseEntity<List<ReCommentVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.reCommentList(commentNumber), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	// 답글삭제
	@RequestMapping(value = "/redelete/{boardNumber}", method = RequestMethod.POST)
	public ResponseEntity<String> redeletePOST(@PathVariable("boardNumber") Integer boardNumber,@RequestBody ReCommentVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.redelete(vo, boardNumber);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	// 댓글수정
	@RequestMapping(value = "/reupdate", method = RequestMethod.POST)
	public ResponseEntity<String> reupdatePOST(@RequestBody ReCommentVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.reupdate(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
