package com.score.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.score.domain.dto.PageMaker;
import com.score.domain.dto.ReviewCriteria;
import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.GameReviewVO;
import com.score.domain.vo.GameVO;
import com.score.service.GameReviewServiceImpl;
import com.score.service.GameServiceImpl;
import com.score.utils.UploadFileUtils;

@Controller
@RequestMapping("/Game")
public class GameController {
	
	@Inject
	private GameServiceImpl service;
	@Inject
	private GameReviewServiceImpl rService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ListGET(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("list", service.listSearchCriteria(cri));
		List<GameVO> gameList = service.list();
		
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    
	    pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		
		return "/Game/GameList";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGET() throws Exception {

		return "/Game/GameInsert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(GameVO vo, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		if(file.getSize() > 0) {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		vo.setGameImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		//vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		service.insert(vo);
		
		return "redirect:/Game";
	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public String readPageGET(@RequestParam("gameNumber") int gameNumber, Model model) throws Exception {
		model.addAttribute("vo", service.readPage(gameNumber));
		ReviewCriteria cri = new ReviewCriteria();
		//model.addAttribute("list", reviewService.listSearchCriteria(cri));
		
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    
	    //pageMaker.setTotalCount(ReviewCriteria.listSearchCount(cri));
	    //구문수정해야됨
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("gameReviewVO", rService.selectReviewList(gameNumber));

		return "/Game/GameReadPage";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("gameNumber") int gameNumber, Model model) throws Exception {
		model.addAttribute("vo", service.readPage(gameNumber));

		return "/Game/GameModifyPage";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(GameVO vo,RedirectAttributes rttr, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getSize() > 0) {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			vo.setGameImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			System.out.println(vo.getGameImg());
		}
		
		service.modify(vo);

		return "redirect:/Game/readPage?gameNumber=" + vo.getGameNumber();
	}
	
	

}