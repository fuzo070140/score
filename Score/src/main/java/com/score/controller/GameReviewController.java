package com.score.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.score.domain.vo.GameReviewVO;
import com.score.domain.vo.GameVO;
import com.score.service.GameReviewServiceImpl;

@Controller
@RequestMapping("/gameReview")
public class GameReviewController {

	@Inject
	private GameReviewServiceImpl service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ListGET(Model model) throws Exception {
		

		return "/GameReview/ReviewList";
	}
	
	@RequestMapping(value = "/list/{gameNumber}" , method = RequestMethod.GET)
	public ResponseEntity<List<GameReviewVO>> list(@PathVariable("gameNumber") Integer gameNumber) {
		ResponseEntity<List<GameReviewVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.select(gameNumber), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/insert/{gameNumber}", method = RequestMethod.GET)
	public String insertGET(HttpServletRequest request,@PathVariable("gameNumber") Integer gameNumber, Model model) throws Exception {
		GameVO vo = service.selectGame(gameNumber);
		//service 를 gameservice 로 변경후
		model.addAttribute("vo", vo);
		//gamemapper 를 사용하게해서 접근해야함 수정해야됨 !!!!!!!!!!!
		
		return "/Game/GameReviewInsertPage";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(GameReviewVO vo, HttpServletRequest request) throws Exception {
		service.insert(vo);
		
		return "redirect:/Game/readPage?gameNumber=" + vo.getGameNumber();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody GameReviewVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.update(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@PathVariable("gameNumber") Integer gameNumber) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			service.delete(gameNumber);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}



}