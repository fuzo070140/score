package com.score.persistence;

import java.util.HashMap;

import com.score.domain.vo.UserVO;

public interface UserDAO {
	
	public int register(UserVO vo)throws Exception;
	
	public UserVO registerCheck(UserVO vo)throws Exception;
	
	public UserVO login(UserVO vo)throws Exception;
	
	public int idCheck(String userID)throws Exception;
	
	public int nickNameCheck(String userNickName)throws Exception;

	public HashMap<String, Object> userSelectAll(int userNumber) throws Exception;
	
}
