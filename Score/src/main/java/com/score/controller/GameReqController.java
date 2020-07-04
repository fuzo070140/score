package com.score.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.GameReqVO;
import com.score.service.GameReqService;
import com.score.service.GameReqServiceImpl;
import com.score.service.GameService;
import com.score.service.GameServiceImpl;
import com.score.utils.UploadFileUtils;

@Controller
@RequestMapping("/gamereq")
public class GameReqController {
	
	@Inject
	private GameReqServiceImpl service;
	
	@Inject
	private GameService gameService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("gameNumber") int gameNumber, Model model) throws Exception {
		model.addAttribute("vo", gameService.readPage(gameNumber));
		
		return "/GameReq/GameReq";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String modifyPOST(GameReqVO vo, Model model, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getSize() > 0) {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			vo.setGameImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		}
		service.insert(vo);
		
		return "redirect:../Game";
	}

}