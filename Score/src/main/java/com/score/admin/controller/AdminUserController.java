package com.score.admin.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.score.domain.admin.vo.AdminUserVO;
import com.score.service.admin.AdminUserServiec;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Inject
	private AdminUserServiec service;

	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request) throws Exception {
		
		return "admin/loginPage";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, AdminUserVO vo) throws Exception {
		
		HttpSession session = request.getSession(true);
		
		String reUrl = null;
		
		AdminUserVO AUVO = service.adminLogin(vo);
		if (AUVO == null) {
			reUrl = "admin/loginPage";
		} else {
			session.setAttribute("AUVO", AUVO);
			reUrl = "admin/adminHome";
		}
		
		return reUrl;
	}

}