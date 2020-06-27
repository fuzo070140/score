package com.score.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.score.domain.vo.BoardVO;
import com.score.domain.vo.CommentVO;
import com.score.domain.vo.UserVO;
import com.score.service.UserServiceImpl;
import com.score.utils.CodeCreate;
import com.score.utils.MailSendThred;
import com.score.utils.UploadFileUtils;

@Controller
@RequestMapping("/User")
public class UserController {

	@Inject
	private UserServiceImpl service;

	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String user(HttpSession session, Model model) throws Exception {
		UserVO Uvo = (UserVO) session.getAttribute("vo");
		HashMap<String, Object> map = service.userSelectAll(Uvo.getUserNumber());
		List<BoardVO> BvoList = (List<BoardVO>) map.get("BvoList");
		List<CommentVO> CvoList = (List<CommentVO>) map.get("CvoList");

		model.addAttribute("BvoList", BvoList);
		model.addAttribute("CvoList", CvoList);

		return "/User/UserMyPage";
	}

	// 일반,기업 분류 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String UserRegisterTypeGET() throws Exception {

		return "/User/UserRegisterType";
	}

	// 일반 가입자 페이지
	@RequestMapping(value = "/registerNomal", method = RequestMethod.GET)
	public String UserRegisterNomalGET() throws Exception {

		return "/User/UserRegisterNomal";
	}

	// 기업 가입자 페이지
	@RequestMapping(value = "/registerBus", method = RequestMethod.GET)
	public String registerGET() throws Exception {

		return "/User/UserRegisterBus";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo, MultipartFile file) throws Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload/userThumb";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		if (file.getSize() > 0) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			vo.setUserThumbImg(File.separator + "imgUpload" + File.separator + "userThumb" + ymdPath + File.separator + fileName);
		} else {
			vo.setUserThumbImg(File.separator + "imgUpload" + File.separator + "userThumb" + File.separator + "none.jpg");
		}
		vo.setUserEmailCheck("yes");
		vo.setUserCategory("Nomal");

		if (service.registerCheck(vo) != null) {
			return "/User/UserRegisterFinFail";
		} else {
			if (service.register(vo) == 1) {
				return "redirect:/";
			} else {
				return "/User/UserRegisterFinFail";
			}
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(HttpServletRequest request, Model model) throws Exception {
		String referer = request.getHeader("referer");
		model.addAttribute("referer", referer);

		return "/User/UserLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(UserVO vo, HttpServletRequest request, String referer) throws Exception {

		HttpSession session = request.getSession(true);
		if (referer == null || referer == "") {
			referer = "/score";
		}

		UserVO Uvo = service.login(vo);
		if (Uvo == null) {
			System.out.println("틀림");
		} else {
			session.setAttribute("vo", Uvo);
		}

		return "redirect:" + referer;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);

		session.invalidate();

		return "/home";
	}

	@ResponseBody
	@RequestMapping(value = "/mailCheck", method = RequestMethod.POST)
	public ResponseEntity<String> MailCheck(@RequestBody UserVO vo, HttpServletRequest request) throws Exception {

		ResponseEntity<String> entity = null;
		try {
			String code = CodeCreate.getCodeCreate();
			HttpSession session = request.getSession();
			session.setAttribute("code", code);
			session.setMaxInactiveInterval(60 * 5);

			MailSendThred.MailSend("fuzo070140@naver.com", vo.getUserEmail(), "이메일 확인코드입니다", code);
			entity = new ResponseEntity<String>("succ", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/codeCheck", method = RequestMethod.GET)
	public ResponseEntity<String> codeCheck(String code, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("code");
		if (sessionCode != null && code != null) {
			if (sessionCode.equals(code)) {
				session.invalidate();
				return new ResponseEntity<String>("succ", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public ResponseEntity<String> idCheck(String userID, HttpServletRequest request) throws Exception {
		System.out.println(userID);
		try {
			System.out.println(service.idCheck(userID));
			if (service.idCheck(userID) == 0) {
				return new ResponseEntity<String>("succ", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/nickNameCheck", method = RequestMethod.GET)
	public ResponseEntity<String> nickNameCheck(String userNickName, HttpServletRequest request) throws Exception {
		System.out.println(userNickName);
		try {
			System.out.println(service.nickNameCheck(userNickName) + "abc");
			if (service.nickNameCheck(userNickName) == 0) {
				return new ResponseEntity<String>("succ", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/ChangePW", method = RequestMethod.GET)
	public String ChangePW() throws Exception {

		return "/User/ChangePW";
	}

	@RequestMapping(value = "/ChangeEmail", method = RequestMethod.GET)
	public String ChangeEmail() throws Exception {

		return "/User/ChangeEmail";
	}

}