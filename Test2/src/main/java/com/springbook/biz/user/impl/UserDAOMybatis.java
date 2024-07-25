package com.springbook.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;	
	
	public UserVO getUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	public UserVO idCheck(UserVO vo) {
		return mybatis.selectOne("UserDAO.idCheck", vo);
	}
	
	public int memberCount(UserVO vo) {
		return mybatis.selectOne("UserDAO.memberCount", vo);
	}
}