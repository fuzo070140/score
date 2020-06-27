package com.score.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.score.domain.vo.BoardVO;
import com.score.domain.vo.CommentVO;
import com.score.domain.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.score.mapper.UserMapper";


	@Override
	public int register(UserVO vo) throws Exception {
		return session.insert(namespace + ".register", vo);
	}


	@Override
	public UserVO login(UserVO vo) throws Exception {
		return session.selectOne(namespace + ".login", vo);
	}


	@Override
	public UserVO registerCheck(UserVO vo) throws Exception {
		return session.selectOne(namespace + ".registerCheck", vo);
	}


	@Override
	public int idCheck(String userID) throws Exception {
		return session.selectOne(namespace + ".idCheck" , userID);
	}


	@Override
	public int nickNameCheck(String userNickName) throws Exception {
		return session.selectOne(namespace + ".nickNameCheck" , userNickName);
	}
	
	@Override
	public HashMap<String, Object> userSelectAll(int userNumber)throws Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<BoardVO> BvoList = new ArrayList<>();
		List<CommentVO> CvoList = new ArrayList<>();
		BvoList = session.selectList("com.score.mapper.BoardMapper.userSelectBoardAll", userNumber);
		CvoList = session.selectList("com.score.mapper.CommentMapper.userSelectCommentAll", userNumber);
		hashMap.put("BvoList", BvoList);
		hashMap.put("RvoList", CvoList);
		
		return hashMap;
	}

}
