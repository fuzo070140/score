package com.score.controller;

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

import com.score.domain.vo.GameReplyVO;
import com.score.service.GameReplyService;

@Controller
@RequestMapping("/GameReply")
public class GameReplyController {
	
	@Inject
	GameReplyService service;
	
	@RequestMapping(value = "/list/{gameNumber}/{gameReplyNumber}" , method = RequestMethod.GET)
	public ResponseEntity<List<GameReplyVO>> list(@PathVariable("gameNumber") Integer gameNumber,@PathVariable("gameReplyNumber") Integer gameReplyNumber) {
		ResponseEntity<List<GameReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.replyList(gameNumber, gameReplyNumber), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//댓글작성
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insertPOST(@RequestBody GameReplyVO vo, HttpServletRequest request) throws Exception {

		ResponseEntity<String> entity = null;
		
		try {
			service.insert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//댓글삭제
	@RequestMapping(value = "/delete/{gameReplyNumber}", method = RequestMethod.POST)
	public ResponseEntity<String> deletePOST(@PathVariable("gameReplyNumber") Integer gameReplyNumber, HttpServletRequest request) throws Exception {

		ResponseEntity<String> entity = null;
		
		try {
			service.delete(gameReplyNumber);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//댓글수정
	@RequestMapping(value = "/update/{gameReplyNumber}/{gameReplyContent}", method = RequestMethod.POST)
	public ResponseEntity<String> updatePOST(@PathVariable("gameReplyNumber") Integer gameReplyNumber,@PathVariable("gameReplyContent") String gameReplyContent, HttpServletRequest request) throws Exception {

		ResponseEntity<String> entity = null;
		
		try {
			service.update(gameReplyNumber, gameReplyContent);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
