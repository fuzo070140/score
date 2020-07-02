package com.score.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.score.domain.admin.vo.AdminUserVO;
import com.score.persistence.admin.AdminUserDAO;

@Service
public class AdminUserServiceImpl implements AdminUserServiec {
	
	@Inject
	AdminUserDAO dao;

	@Override
	public AdminUserVO adminLogin(AdminUserVO vo) throws Exception {
		return dao.adminLogin(vo);
	}

}
