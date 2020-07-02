package com.score.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.score.domain.dto.SearchCriteria;

@Controller
@RequestMapping("/gamereq")
public class GameReqController {
	
	@Inject
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ListGET(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		
		return "/";
	}
	
	

}