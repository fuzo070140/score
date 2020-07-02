package com.score.persistence.admin;

import com.score.domain.admin.vo.AdminUserVO;

public interface AdminUserDAO {
	
	public AdminUserVO adminLogin(AdminUserVO vo)throws Exception;

}
